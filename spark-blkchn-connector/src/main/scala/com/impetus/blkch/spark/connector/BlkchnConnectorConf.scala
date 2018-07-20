package com.impetus.blkch.spark.connector

import com.impetus.blkch.jdbc.BlkchnConnection
import com.impetus.blkch.spark.connector.util.Logging
import org.apache.spark.SparkConf

abstract class BlkchnConnectorConf(conf: SparkConf) extends Serializable  with Logging {

  def getConnection(): BlkchnConnection

}
