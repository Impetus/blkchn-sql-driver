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
package com.impetus.blkch.sql.parser;

import com.impetus.blkch.sql.function.ClassName;
import com.impetus.blkch.sql.function.CreateFunction;
import com.impetus.blkch.sql.insert.Insert;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.QueryItemInterface;

public class LogicalPlan extends TreeNode implements QueryItemInterface {

    private TreeNode currentNode;

    private Query query;

    private CreateFunction createFunction;

    private ClassName className;
    
    private Insert insert;

    public LogicalPlan(String description) {
        super(description);
    }

    public TreeNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(TreeNode currentNode) {
        this.currentNode = currentNode;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public CreateFunction getCreateFunction() {return createFunction;}

    public void setCreateFunction(CreateFunction createFunction){
        this.createFunction = createFunction;
    }

    public ClassName getClassName(){ return className;}

    public void setClassName(ClassName className){
        this.className = className;
    }

    public Insert getInsert()
    {
        return insert;
    }

    public void setInsert(Insert insert)
    {
        this.insert = insert;
    }


}
