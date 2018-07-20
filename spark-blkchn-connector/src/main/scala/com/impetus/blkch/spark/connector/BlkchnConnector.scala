package com.impetus.blkch.spark.connector

import java.sql.ResultSet

import com.impetus.blkch.jdbc.{BlkchnConnection, BlkchnStatement}
import com.impetus.blkch.spark.connector.util.Logging
import org.apache.spark.SparkConf

class BlkchnConnector(conf: BlkchnConnectorConf) extends Serializable with Logging {

  def createStatement(): BlkchnStatement = {
    conf.getConnection().createStatement().asInstanceOf[BlkchnStatement]
  }

  def withStatementDo[T](code: BlkchnStatement => T): T = {
    closeResourceAfterUse(createStatement()) { statement =>
      code(statement)
    }
  }

  def closeResourceAfterUse[T, C <: { def close() }](closeable: C)(code: C => T): T = {
    try (code(closeable)) finally {
      closeable.close();
    }
  }

}