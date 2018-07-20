package org.apache.spark.sql.blkch

import com.impetus.blkch.spark.connector.BlkchnConnector
import com.impetus.blkch.spark.connector.rdd.BlkchnRDD
import com.impetus.blkch.spark.connector.util.Logging
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.sql.sources.{BaseRelation, TableScan}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

private[sql] case class BlkchnSourceRelation(rdd: BlkchnRDD[Row], schema: StructType)(@transient val sqlContext: SQLContext)
  extends BaseRelation with TableScan with Logging {

  override def buildScan(): RDD[Row] = rdd
}
