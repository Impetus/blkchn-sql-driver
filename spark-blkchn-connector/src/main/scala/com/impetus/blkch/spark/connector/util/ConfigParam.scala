package com.impetus.blkch.spark.connector.util

case class ConfigParam[T] (val name: String, val default: T, val description: String)
