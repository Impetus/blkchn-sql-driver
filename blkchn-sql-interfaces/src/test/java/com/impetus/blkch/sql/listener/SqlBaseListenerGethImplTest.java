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
package com.impetus.blkch.sql.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.impetus.blkch.sql.generated.BlkchnSqlLexer;
import com.impetus.blkch.sql.generated.BlkchnSqlListener;
import com.impetus.blkch.sql.generated.BlkchnSqlParser;

public class SqlBaseListenerGethImplTest {

    @BeforeClass
    public static void runOnceBeforeClass() {
    }

    @AfterClass
    public static void runOnceAfterClass() {
    }

    @Before
    public void runBeforeTestMethod() {
    }

    @After
    public void runAfterTestMethod() {
    }

    @Test
    public void test_nona_tracer() {
        CharStream input = null;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("sql/input.sql").getFile());
        try {
            input = new ANTLRInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BlkchnSqlLexer lexer = new BlkchnSqlLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BlkchnSqlParser parser = new BlkchnSqlParser(tokens);
        ParseTree tree = parser.singleStatement();

        ParseTreeWalker walker = new ParseTreeWalker();
        BlkchnSqlListener extractor = new SqlBaseListenerGethImpl(parser);
        walker.walk(extractor, tree);
    }

}
