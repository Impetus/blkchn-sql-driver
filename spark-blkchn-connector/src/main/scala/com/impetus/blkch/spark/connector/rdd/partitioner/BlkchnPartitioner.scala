package com.impetus.blkch.spark.connector.rdd.partitioner

import com.impetus.blkch.spark.connector.BlkchnConnector
import com.impetus.blkch.spark.connector.rdd.ReadConf
import com.impetus.blkch.spark.connector.util.Logging

// Implement this with an empty constructor
trait BlkchnPartitioner extends Serializable with Logging {

  def getPartitions(connector: BlkchnConnector, readConf: ReadConf): Array[BlkchnPartition]

}
