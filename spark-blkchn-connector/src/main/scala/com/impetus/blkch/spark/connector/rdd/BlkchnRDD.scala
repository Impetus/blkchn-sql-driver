package com.impetus.blkch.spark.connector.rdd

import java.sql.{ResultSetMetaData, Types}

import com.impetus.blkch.spark.connector.rdd.partitioner.BlkchnPartition
import com.impetus.blkch.spark.connector.{BlkchnConnector}
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema
import org.apache.spark.sql.types._
import org.apache.spark.{Partition, SparkContext, TaskContext}
import java.math.BigInteger
import scala.reflect.ClassTag

class BlkchnRDD[R: ClassTag](@transient sc: SparkContext,
                             private[connector] val connector: Broadcast[BlkchnConnector],
                             private[connector] val readConf: ReadConf) extends RDD[R](sc, Nil) {

  override protected def getPartitions: Array[Partition] = {
    readConf.partitioner.getPartitions(connector.value, readConf).asInstanceOf[Array[Partition]]
  }

  override def compute(split: Partition, context: TaskContext): Iterator[R] = {
    connector.value.withStatementDo {
      stat =>
        val partition = split.asInstanceOf[BlkchnPartition]
        stat.setPageRange(partition.range)
        val rs = stat.executeQuery(partition.readConf.query)
        var buffer = scala.collection.mutable.ArrayBuffer[R]()
        val metadata = rs.getMetaData
        val columnCount = metadata.getColumnCount
        while(rs.next()) {
          val rowVals = (for(i <- 1 to columnCount) yield {
            if(rs.getObject(i).isInstanceOf[BigInteger]){
              val dataValue = new BigDecimal(new java.math.BigDecimal(new BigInteger(rs.getObject(i).toString)))
              (dataValue.asInstanceOf[Any], StructField(metadata.getColumnLabel(i), DecimalType(38,0), true))
            } else if(rs.getObject(i).isInstanceOf[java.util.ArrayList[_]]) {
              handleExtraType(i, metadata, rs.getObject(i))
            }else {
              (rs.getObject(i).asInstanceOf[Any], getStructField(i, metadata))
            }
          }).toArray
          buffer = buffer :+ new GenericRowWithSchema(rowVals.map(_._1), StructType(rowVals.map(_._2))).asInstanceOf[R]
        }
        buffer.toIterator
    }
  }

  private def getStructField(index: Int, metadata: ResultSetMetaData): StructField = {
    val dataType = metadata.getColumnType(index) match {
        case Types.INTEGER => IntegerType
        case Types.DOUBLE => DoubleType
        case Types.BIGINT => LongType
        case Types.FLOAT => FloatType
        case Types.BOOLEAN => BooleanType
        case _ => StringType
      }
    StructField(metadata.getColumnLabel(index), dataType, true)
  }

  def handleExtraType(index: Int, metadata: ResultSetMetaData,data: java.lang.Object):(Any,StructField) = ???
}
