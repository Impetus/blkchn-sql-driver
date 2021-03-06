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
import static com.impetus.blkch.sql.UtilityClass.createFilterItem;
import static com.impetus.blkch.sql.UtilityClass.createLogicalOperation;
import static com.impetus.blkch.sql.UtilityClass.createOrderItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.impetus.blkch.sql.query.Comparator.ComparisionOperator;
import com.impetus.blkch.sql.query.HavingClause;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.LogicalOperation;
import com.impetus.blkch.sql.query.LogicalOperation.Operator;
import com.impetus.blkch.sql.query.OrderingDirection.Direction;
import com.impetus.blkch.sql.query.SelectItem;

public class GroupedDataFrameTest extends TestCase {

    private GroupedDataFrame groupedDataFrame;

    @Before
    protected void setUp() throws Exception {
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList(7, "CR7", "Real Madrid", 32, "Winger"));
        data.add(Arrays.asList(10, "Messi", "FCB", 30, "Striker"));
        data.add(Arrays.asList(9, "Benzema", "Real Madrid", 32, "Striker"));
        data.add(Arrays.asList(1, "Iker", "Porto FC", 38, "Goal Keeper"));
        data.add(Arrays.asList(4, "Ramos", "Real Madrid", 34, "Defender"));
        data.add(Arrays.asList(2, "Varane", "Real Madrid", 24, "Defender"));
        data.add(Arrays.asList(10, "Cavani", "PSG", 30, "Striker"));
        data.add(Arrays.asList(9, "Neymar", "PSG", 27, "Striker"));
        data.add(Arrays.asList(15, "Casemiro", "Real Madrid", 24, "Mid Fielder"));
        data.add(Arrays.asList(8, "Kroos", "Real Madrid", 33, "Mid Fielder"));
        List<String> columns = Arrays.asList("jersey_no", "name", "club", "age", "position");
        Map<String, String> aliasMapping = new HashMap<>();
        aliasMapping.put("jersey_name", "name");
        List<Integer> groupIndices = Arrays.asList(2, 4);
        groupedDataFrame = new GroupedDataFrame(groupIndices, data, columns, aliasMapping);
    }

    @Test
    public void testSelect() {
        SelectItem simpleFunc = new SelectItem();
        simpleFunc.addChildNode(createAggregateFunction("count", "jersey_no"));
        simpleFunc.addChildNode(new IdentifierNode("cnt"));
        List<SelectItem> selectItems = Arrays.asList(createColSelectItem("club"), createColSelectItem("position"),
                simpleFunc);
        DataFrame afterSelect = groupedDataFrame.select(selectItems).order(
                Arrays.asList(createOrderItem("club", Direction.ASC), createOrderItem("position", Direction.ASC)));
        List<List<Object>> expectedData = Arrays.asList(Arrays.asList("FCB", "Striker", 1),
                Arrays.asList("PSG", "Striker", 2), Arrays.asList("Porto FC", "Goal Keeper", 1),
                Arrays.asList("Real Madrid", "Defender", 2), Arrays.asList("Real Madrid", "Mid Fielder", 2),
                Arrays.asList("Real Madrid", "Striker", 1), Arrays.asList("Real Madrid", "Winger", 1));
        assertEquals(expectedData, afterSelect.getData());
        assertEquals(Arrays.asList("club", "position", "count(jersey_no)"), afterSelect.getColumns());
    }

    public void testSingleHaving() {
        SelectItem simpleFunc = new SelectItem();
        simpleFunc.addChildNode(createAggregateFunction("count", "jersey_no"));
        simpleFunc.addChildNode(new IdentifierNode("cnt"));
        List<SelectItem> selectItems = Arrays.asList(createColSelectItem("club"), createColSelectItem("position"),
                simpleFunc);
        HavingClause havingClause = new HavingClause();
        havingClause.addChildNode(createFilterItem("club", ComparisionOperator.EQ, "Real Madrid"));
        DataFrame afterHaving = groupedDataFrame.having(havingClause).select(selectItems);
        List<List<Object>> expectedData = Arrays.asList(Arrays.asList("Real Madrid", "Mid Fielder", 2),
                Arrays.asList("Real Madrid", "Striker", 1), Arrays.asList("Real Madrid", "Defender", 2),
                Arrays.asList("Real Madrid", "Winger", 1));
        assertEquals(expectedData, afterHaving.getData());
    }

    public void testMultipleHaving() {
        SelectItem simpleFunc = new SelectItem();
        simpleFunc.addChildNode(createAggregateFunction("count", "jersey_no"));
        simpleFunc.addChildNode(new IdentifierNode("cnt"));
        List<SelectItem> selectItems = Arrays.asList(createColSelectItem("club"), createColSelectItem("position"),
                simpleFunc);
        LogicalOperation innerOp = createLogicalOperation(
                createFilterItem("club", ComparisionOperator.EQ, "Real Madrid"),
                createFilterItem("club", ComparisionOperator.EQ, "PSG"), Operator.OR);
        LogicalOperation logicalOperation = createLogicalOperation(innerOp,
                createFilterItem("position", ComparisionOperator.EQ, "Striker"), Operator.AND);
        HavingClause havingClause = new HavingClause();
        havingClause.addChildNode(logicalOperation);
        DataFrame afterHaving = groupedDataFrame.having(havingClause).select(selectItems);
        List<List<Object>> expectedData = Arrays.asList(Arrays.asList("Real Madrid", "Striker", 1),
                Arrays.asList("PSG", "Striker", 2));
        assertEquals(expectedData, afterHaving.getData());
    }
    
    public void testCountWithAlias() {
        SelectItem simpleFunc = new SelectItem();
        simpleFunc.addChildNode(createAggregateFunction("count", "jersey_no"));
        simpleFunc.addChildNode(new IdentifierNode("cnt"));
        List<SelectItem> selectItems = Arrays.asList(createColSelectItem("club"), createColSelectItem("position"), simpleFunc);
        DataFrame afterSelect = groupedDataFrame.select(selectItems);
        List<String> expectedCols = Arrays.asList("club", "position", "count(jersey_no)");
        assertEquals(expectedCols, afterSelect.getColumns());
    }
}
