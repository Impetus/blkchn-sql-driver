package com.impetus.blkch.spark.connector.rdd

import com.impetus.blkch.spark.connector.rdd.partitioner.{BlkchnPartitioner}
import com.impetus.blkch.spark.connector.util.ConfigParam
import org.apache.spark.SparkConf
import com.impetus.blkch.BlkchnException

case class ReadConf(splitCount: Option[Int] = ReadConf.SplitCount.default,
                    fetchSizeInRows: Option[Int] = ReadConf.FetchSizeInRows.default,
                    query: String
                   )(implicit val partitioner: BlkchnPartitioner) {
  
  def asOptions(): Map[String, String] = {
    var options = Map(ReadConf.Query.name -> query)
    options = splitCount match {
      case Some(x) => options + (ReadConf.SplitCount.name -> x.toString)
      case None => options
    }
    options = fetchSizeInRows match {
      case Some(x) => options + (ReadConf.FetchSizeInRows.name -> x.toString)
      case None => options
    }
    options = if(partitioner != null) options + (ReadConf.Partitioner.name -> partitioner.getClass.getName.replaceAll("\\$","")) else options
    options
  }
}

object ReadConf {

  val SplitCount = ConfigParam[Option[Int]]("spark.blkchn.rdd.splitcount",
    None,
    """
      | Specify the number of spark partitions to read the
      | blockchain table into. This parameter is used in SparkSQL
      | and DataFrame Options.
    """.stripMargin)

  val FetchSizeInRows = ConfigParam[Option[Int]]("spark.blkchn.rdd.fetch.sizeinrows",
    Some(1000),
    """
      | Number of SQL rows fetched per driver request
    """.stripMargin)

  val Query = ConfigParam[String]("spark.blkchn.query",
    "",
    """
      | Query to be executed on blockchain network from Spark.
    """.stripMargin)

  val Partitioner = ConfigParam[BlkchnPartitioner]("spark.blkchn.partitioner",
    null,
    """
      | Partitioner implementation to use for partitioning RDDs.
    """.stripMargin)

  val Properties = Set(
    SplitCount,
    FetchSizeInRows,
    Query,
    Partitioner
  )

  def apply(conf: SparkConf): ReadConf = apply(conf, Map())

  def apply(conf: SparkConf, options: Map[String, String]): ReadConf = {
    require(conf.getOption(Query.name).isDefined || options.contains(Query.name),
      s"""
        | Configuration parameter ${Query.name} should be set
      """.stripMargin)
      val partitionerName = conf.get(Partitioner.name, options.getOrElse(Partitioner.name, ""))
      if("".equals(partitionerName)) {
        throw new BlkchnException("Not able to find valid partitioner")
      }
    val _partitioner = Class.forName(partitionerName).getConstructor()
                        .newInstance().asInstanceOf[BlkchnPartitioner]
    ReadConf(
      splitCount = conf.getOption(SplitCount.name).map(_.toInt) match {
        case Some(split) => Some(split)
        case None => options.get(SplitCount.name).map(_.toInt)
      },
      fetchSizeInRows = conf.getOption(FetchSizeInRows.name).map(_.toInt) match {
        case Some(fetchSize) => Some(fetchSize)
        case None => options.get(FetchSizeInRows.name).map(_.toInt)
      },
      query = conf.get(Query.name, options.getOrElse(Query.name, Query.default))
      
    )(partitioner = _partitioner)
  }
}
