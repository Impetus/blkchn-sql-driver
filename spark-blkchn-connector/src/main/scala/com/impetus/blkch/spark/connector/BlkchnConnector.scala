/*******************************************************************************
* * Copyright 2018 Impetus Infotech.
* *
* * Licensed under the Apache License, Version 2.0 (the "License");
* * you may not use this file except in compliance with the License.
* * You may obtain a copy of the License at
* *
* * http://www.apache.org/licenses/LICENSE-2.0
* *
* * Unless required by applicable law or agreed to in writing, software
* * distributed under the License is distributed on an "AS IS" BASIS,
* * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* * See the License for the specific language governing permissions and
* * limitations under the License.
******************************************************************************/
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