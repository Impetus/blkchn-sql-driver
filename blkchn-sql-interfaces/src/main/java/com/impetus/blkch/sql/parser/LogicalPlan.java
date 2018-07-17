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
package com.impetus.blkch.sql.parser;

import com.impetus.blkch.sql.asset.CreateAsset;
import com.impetus.blkch.sql.asset.DropAsset;
import com.impetus.blkch.sql.function.CallFunction;
import com.impetus.blkch.sql.function.ClassName;
import com.impetus.blkch.sql.function.CreateFunction;
import com.impetus.blkch.sql.function.DeleteFunction;
import com.impetus.blkch.sql.function.UpgradeFunction;
import com.impetus.blkch.sql.insert.Insert;
import com.impetus.blkch.sql.query.Query;
import com.impetus.blkch.sql.query.QueryItemInterface;
import com.impetus.blkch.sql.smartcontract.SmartCnrtDeploy;

public class LogicalPlan extends TreeNode implements QueryItemInterface {

    private TreeNode currentNode;

    private Query query;

    private CreateFunction createFunction;

    private ClassName className;

    private Insert insert;

    private CallFunction callFunction;

    private CreateAsset createAsset;

    private DeleteFunction deleteFunction;

    private DropAsset dropAsset;

    private UpgradeFunction upgradeFunction;

    private SQLType type;

    private SmartCnrtDeploy smartCnrtDeploy;

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

    public CreateFunction getCreateFunction() {
        return createFunction;
    }

    public void setCreateFunction(CreateFunction createFunction) {
        this.createFunction = createFunction;
    }

    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

    public Insert getInsert() {
        return insert;
    }

    public void setInsert(Insert insert) {
        this.insert = insert;
    }

    public CallFunction getCallFunction() {
        return callFunction;
    }

    public void setCallFunction(CallFunction callFunction) {
        this.callFunction = callFunction;
    }

    public CreateAsset getCreateAsset() {
        return createAsset;
    }

    public void setCreateAsset(CreateAsset createAsset) {
        this.createAsset = createAsset;
    }

    public DeleteFunction getDeleteFunction() {
        return deleteFunction;
    }

    public void setDeleteFunction(DeleteFunction deleteFunction) {
        this.deleteFunction = deleteFunction;
    }

    public DropAsset getDropAsset() {
        return dropAsset;
    }

    public void setDropAsset(DropAsset dropAsset) {
        this.dropAsset = dropAsset;
    }

    public UpgradeFunction getUpgradeFunction() {
        return upgradeFunction;
    }

    public void setSmartCnrtDeploy(SmartCnrtDeploy smartCnrtDeploy) {
        this.smartCnrtDeploy = smartCnrtDeploy;

    }

    public SmartCnrtDeploy getSmartCnrtDeploy() {
        return smartCnrtDeploy;
    }

    public void setUpgradeFunction(UpgradeFunction upgradeFunction) {
        this.upgradeFunction = upgradeFunction;
    }

    public SQLType getType() {
        return type;
    }

    public void setType(SQLType type) {
        this.type = type;
    }
    
    @Override
    public Object clone() {
        LogicalPlan plan = (LogicalPlan) super.clone();
        if(this.getType() != null && this.getType().equals(SQLType.QUERY)) {
            plan.query = (Query) this.query.clone();
        }

        return plan;
    }

    public static enum SQLType {

                                QUERY,

                                INSERT,

                                CREATE_FUNCTION,

                                CALL_FUNCTION,

                                CREATE_ASSET,

                                DELETE_FUNCTION,

                                DROP_ASSET,

                                UPGRADE_FUNCTION,

                                DEPLOY_SMARTCONTRACT
    }

}
