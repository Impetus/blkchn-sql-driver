/*******************************************************************************
 * * Copyright 2017 Impetus Infotech.
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
package com.impetus.blkch.sql.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.blkch.sql.generated.BlkchnSqlBaseListener;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;

public class SqlBaseListenerGethImpl extends BlkchnSqlBaseListener {

    private static final Logger logger = LoggerFactory.getLogger(SqlBaseListenerGethImpl.class);

    BlkchnSqlParser parser;

    public SqlBaseListenerGethImpl(BlkchnSqlParser parser) {
        this.parser = parser;
    }

    public void enterSingleStatement(BlkchnSqlParser.SingleStatementContext ctx) {
        logger.info("Implement listener interface just for testing availability.\n "
                + "All actual implementation is via visitor pattern");
    }

}