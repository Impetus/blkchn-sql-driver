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
package com.impetus.blkch.sql;

import static com.impetus.blkch.sql.UtilityClass.createAggregateFunction;
import static com.impetus.blkch.sql.UtilityClass.createColSelectItem;
import static com.impetus.blkch.sql.UtilityClass.createLimitClause;
import static com.impetus.blkch.sql.UtilityClass.createOrderItem;
import static com.impetus.blkch.sql.UtilityClass.createStarSelectItem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.impetus.blkch.sql.query.FunctionNode;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LimitClause;
import com.impetus.blkch.sql.query.OrderItem;
import com.impetus.blkch.sql.query.OrderingDirection.Direction;
import com.impetus.blkch.sql.query.SelectItem;

public class DataFrameTest extends TestCase {
    
    private DataFrame dataframe;
    private DataFrame dataframeIntegerAsString;
    
    @Before
    protected void setUp() throws Exception {
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList(7, "CR7", "Real Madrid", 32, "Winger"));
        data.add(Arrays.asList(10, "Messi", "FCB", 30, "Striker"));
        data.add(Arrays.asList(9, "Benzema", "Real Madrid", 32, "Striker"));
        data.add(Arrays.asList(1, "Iker", "Porto FC", 38, "Goal Keeper"));
        data.add(Arrays.asList(4, "Ramos", "Real Madrid", 34, "Defender"));
        data.add(Arrays.asList(2, "Varane", "Real Madrid", 24, "Defender"));
        data.add(Arrays.asList(10, "Rooney", "Everton", 31, "Striker"));
        data.add(Arrays.asList(9, "Neymar", "PSG", 27, "Striker"));
        data.add(Arrays.asList(15, "Casemiro", "Real Madrid", 24, "Mid Fielder"));
        data.add(Arrays.asList(8, "Iniesta", "FCB", 33, "Mid Fielder"));
        List<String> columns = Arrays.asList("jersey_no", "name", "club", "age", "position");
        Map<String, String> aliasMapping = new HashMap<>();
        aliasMapping.put("jersey_name", "name");
        dataframe = new DataFrame(data, columns, aliasMapping);
    }

    @Test
    public void testSelectColumns() {
        List<SelectItem> selectItems = Arrays.asList(createColSelectItem("jersey_no"), createColSelectItem("jersey_name"), createColSelectItem("age"));
        DataFrame afterSelect = dataframe.select(selectItems);
        List<List<Object>> expectedData = Arrays.asList(
                Arrays.asList(7, "CR7", 32), Arrays.asList(10, "Messi", 30), Arrays.asList(9, "Benzema", 32),
                Arrays.asList(1, "Iker", 38), Arrays.asList(4, "Ramos", 34), Arrays.asList(2, "Varane", 24),
                Arrays.asList(10, "Rooney", 31), Arrays.asList(9, "Neymar", 27), Arrays.asList(15, "Casemiro", 24),
                Arrays.asList(8, "Iniesta", 33)
                );
        assertEquals(Arrays.asList("jersey_no", "jersey_name", "age"), afterSelect.getColumns());
        assertEquals(dataframe.getAliasMapping(), afterSelect.getAliasMapping());
        assertEquals(expectedData, afterSelect.getData());
    }
    
    @Test
    public void testSelectStar() {
        List<SelectItem> selectItems = Arrays.asList(createStarSelectItem());
        DataFrame afterSelect = dataframe.select(selectItems);
        assertEquals(dataframe.getColumns(), afterSelect.getColumns());
        assertEquals(dataframe.getAliasMapping(), afterSelect.getAliasMapping());
        assertEquals(dataframe.getData(), afterSelect.getData());
    }
    
    @Test
    public void testSelectAggregateFunction() {
        SelectItem simpleFunc = new SelectItem();
        simpleFunc.addChildNode(createAggregateFunction("count", "jersey_no"));
        simpleFunc.addChildNode(new IdentifierNode("cnt"));
        SelectItem multiFunc = new SelectItem();
        FunctionNode topFunc = new FunctionNode();
        topFunc.addChildNode(new IdentifierNode("count"));
        topFunc.addChildNode(createAggregateFunction("sum", "age"));
        multiFunc.addChildNode(topFunc);
        List<SelectItem> selectItems = Arrays.asList(simpleFunc, multiFunc);
        DataFrame afterSelect = dataframe.select(selectItems);
        List<List<Object>> expectedData = Arrays.asList(Arrays.asList(10, 1));
        assertEquals(Arrays.asList("count(jersey_no)", "count(sum(age))"), afterSelect.getColumns());
        assertEquals(dataframe.getAliasMapping(), afterSelect.getAliasMapping());
        assertEquals(expectedData, afterSelect.getData());
    }
    
    @Test
    public void testSingleElementAscOrder() {
        List<OrderItem> orderItems = Arrays.asList(createOrderItem("age", Direction.ASC));
        List<SelectItem> selectItems = Arrays.asList(createColSelectItem("age"), createColSelectItem("name"));
        DataFrame afterOrder = dataframe.order(orderItems).select(selectItems);
        List<List<Object>> expectedData = Arrays.asList(
                    Arrays.asList(24, "Varane"), Arrays.asList(24, "Casemiro"), Arrays.asList(27, "Neymar"), Arrays.asList(30, "Messi"),
                    Arrays.asList(31, "Rooney"), Arrays.asList(32, "CR7"), Arrays.asList(32, "Benzema"), Arrays.asList(33, "Iniesta"),
                    Arrays.asList(34, "Ramos"), Arrays.asList(38, "Iker")
                );
        assertEquals(dataframe.getAliasMapping(), afterOrder.getAliasMapping());
        assertEquals(expectedData, afterOrder.getData());
    }
    
    @Test
    public void testSingleElementDescOrder() {
        List<OrderItem> orderItems = Arrays.asList(createOrderItem("jersey_no", Direction.DESC));
        List<SelectItem> selectItems = Arrays.asList(createColSelectItem("jersey_no"), createColSelectItem("name"));
        DataFrame afterOrder = dataframe.order(orderItems).select(selectItems);
        List<List<Object>> expectedData = Arrays.asList(
                Arrays.asList(15, "Casemiro"), Arrays.asList(10, "Messi"), Arrays.asList(10, "Rooney"), Arrays.asList(9, "Benzema"),
                Arrays.asList(9, "Neymar"), Arrays.asList(8, "Iniesta"), Arrays.asList(7, "CR7"), Arrays.asList(4, "Ramos"),
                Arrays.asList(2, "Varane"), Arrays.asList(1, "Iker")
            );
        assertEquals(expectedData, afterOrder.getData());
    }
    
    @Test
    public void testMultipleElementOrder() {
        List<OrderItem> orderItems = Arrays.asList(createOrderItem("club", Direction.DESC), createOrderItem("age", Direction.ASC));
        List<SelectItem> selectItems = Arrays.asList(createColSelectItem("club"), createColSelectItem("age"), createColSelectItem("name"));
        DataFrame afterOrder = dataframe.order(orderItems).select(selectItems);
        List<List<Object>> expectedData = Arrays.asList(
                Arrays.asList("Real Madrid", 24, "Varane"), Arrays.asList("Real Madrid", 24, "Casemiro"),
                Arrays.asList("Real Madrid", 32, "CR7"), Arrays.asList("Real Madrid", 32, "Benzema"),
                Arrays.asList("Real Madrid", 34, "Ramos"), Arrays.asList("Porto FC", 38, "Iker"), Arrays.asList("PSG", 27, "Neymar"),
                Arrays.asList("FCB", 30, "Messi"), Arrays.asList("FCB", 33, "Iniesta"), Arrays.asList("Everton", 31, "Rooney")
                
            );
        assertEquals(expectedData, afterOrder.getData());
    }
    
    @Test
    public void testLimitClause() {
        LimitClause limitClause = createLimitClause("3");
        DataFrame afterLimit = dataframe.limit(limitClause);
        assertEquals(3, afterLimit.getData().size());
    }

    @Test
    public void testOrderByOnBigInteger(){

        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList(new BigInteger("7"), "CR7", "Real Madrid", "26", "Winger"));
        data.add(Arrays.asList(new BigInteger("4"), "Ramos", "Real Madrid", "27", "Defender"));
        data.add(Arrays.asList(new BigInteger("9"), "Benzema", "Real Madrid", "31", "Striker"));
        data.add(Arrays.asList(new BigInteger("14"), "Casemiro", "Real Madrid", "25", "Mid Fielder"));
        data.add(Arrays.asList(new BigInteger("5"), "Varane", "Real Madrid", "24", "Defender"));
       
        List<String> columns = Arrays.asList("jersey_no", "name", "club", "age", "position");
        Map<String, String> aliasMapping = new HashMap<>();
        aliasMapping.put("jersey_name", "name");
        dataframeIntegerAsString = new DataFrame(data, columns, aliasMapping);

        List<OrderItem> orderItems = Arrays.asList(createOrderItem("jersey_no", Direction.ASC));
        List<SelectItem> selectItems = Arrays.asList(createColSelectItem("jersey_no"),createColSelectItem("club"), createColSelectItem("age"), createColSelectItem("name"));
        DataFrame afterOrder = dataframeIntegerAsString.order(orderItems).select(selectItems);
        List<List<Object>> expectedData = Arrays.asList(
                Arrays.asList(new BigInteger("4"),"Real Madrid", "27", "Ramos"),
                Arrays.asList(new BigInteger("5"),"Real Madrid", "24", "Varane"),
                Arrays.asList(new BigInteger("7"),"Real Madrid", "26", "CR7"),
                Arrays.asList(new BigInteger("9"),"Real Madrid", "31", "Benzema"),
                Arrays.asList(new BigInteger("14"),"Real Madrid", "25", "Casemiro")
        );
        assertEquals(expectedData, afterOrder.getData());
    }
    
    @Test
    public void testOrderByWithNulls() {
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList(7, "CR7", "Real Madrid", 26, "Winger"));
        data.add(Arrays.asList(4, "Ramos", "Real Madrid", 27, "Defender"));
        data.add(Arrays.asList(9, "Benzema", "Real Madrid", 31, "Striker"));
        data.add(Arrays.asList(14, "Casemiro", "Real Madrid", 25, "Mid Fielder"));
        data.add(Arrays.asList(5, "Varane", "Real Madrid", 24, "Defender"));
        data.add(Arrays.asList(52, null, "Real Madrid", 16, "Mid Fielder"));
        data.add(Arrays.asList(0, null, "Real Madrid", 14, null));
        data.add(Arrays.asList(16, null, "Real Madrid", 15, "Striker"));
        List<String> columns = Arrays.asList("jersey_no", "name", "club", "age", "position");
        Map<String, String> aliasMapping = new HashMap<>();
        aliasMapping.put("pos", "position");
        DataFrame df = new DataFrame(data, columns, aliasMapping);
        List<OrderItem> orderItems = Arrays.asList(createOrderItem("name", Direction.ASC), createOrderItem("pos", Direction.DESC));
        List<SelectItem> selectItems = Arrays.asList(createColSelectItem("jersey_no"), createColSelectItem("name"), createColSelectItem("club"), 
                createColSelectItem("age"), createColSelectItem("pos"));
        DataFrame afterOrder = df.order(orderItems).select(selectItems);
        List<List<Object>> expectedData = Arrays.asList(
                Arrays.asList(9, "Benzema", "Real Madrid", 31, "Striker"),
                Arrays.asList(7, "CR7", "Real Madrid", 26, "Winger"),
                Arrays.asList(14, "Casemiro", "Real Madrid", 25, "Mid Fielder"),
                Arrays.asList(4, "Ramos", "Real Madrid", 27, "Defender"),
                Arrays.asList(5, "Varane", "Real Madrid", 24, "Defender"),
                Arrays.asList(0, null, "Real Madrid", 14, null),
                Arrays.asList(16, null, "Real Madrid", 15, "Striker"),
                Arrays.asList(52, null, "Real Madrid", 16, "Mid Fielder")
                );
        assertEquals(expectedData, afterOrder.getData());
    }
}
