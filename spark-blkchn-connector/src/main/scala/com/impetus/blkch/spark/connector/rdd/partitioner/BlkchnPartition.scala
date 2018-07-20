package com.impetus.blkch.spark.connector.rdd.partitioner

import com.impetus.blkch.spark.connector.rdd.ReadConf
import com.impetus.blkch.spark.connector.util.Logging
import com.impetus.blkch.sql.query.RangeNode
import org.apache.spark.Partition
import java.{lang => jl}

class BlkchnPartition(val index: Int, val range: RangeNode[_], val readConf: ReadConf) extends Partition with Logging