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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.impetus.blkch.BlkchnException;
import com.impetus.blkch.sql.asset.Asset;
import com.impetus.blkch.sql.asset.ColumnType;
import com.impetus.blkch.sql.asset.ColumnTypeList;
import com.impetus.blkch.sql.asset.FieldDelimiter;
import com.impetus.blkch.sql.asset.RecordDelimiter;
import com.impetus.blkch.sql.asset.StorageType;
import com.impetus.blkch.sql.parser.LogicalPlan.SQLType;
import com.impetus.blkch.sql.query.IdentifierNode;

public abstract class AbstractAssetManager {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BlockchainVisitor.class);
    
    protected LogicalPlan logicalPlan;

    @SuppressWarnings("unchecked")
    public void executeCreateAsset() {
        if (!logicalPlan.getType().equals(SQLType.CREATE_ASSET)) {
            throw new BlkchnException("Statement executed is not of type 'CREATE ASSET'");
        }
        JSONObject json = new JSONObject();
        TreeNode createAsset = logicalPlan.getCreateAsset();
        String asset = createAsset.getChildType(Asset.class, 0).getChildType(IdentifierNode.class, 0).getValue();
        json.put("storageType", createAsset.getChildType(StorageType.class, 0).getChildType(IdentifierNode.class, 0)
                .getValue().trim());
        if (createAsset.hasChildType(ColumnTypeList.class)) {
            List<ColumnType> colTypes = createAsset.getChildType(ColumnTypeList.class, 0)
                    .getChildType(ColumnType.class);
            JSONArray colTypeArr = new JSONArray();
            for(ColumnType colType : colTypes) {
                JSONObject colTypeJSON = new JSONObject();
                colTypeJSON.put("colName", colType.getChildType(IdentifierNode.class, 0).getValue().trim());
                colTypeJSON.put("colType", colType.getChildType(IdentifierNode.class, 1).getValue().trim());
                colTypeArr.add(colTypeJSON);
            }
            json.put("columnDetails", colTypeArr);
        } else if("CSV".equals(json.get("storageType").toString().trim())) {
            throw new BlkchnException("Column Details should be mentioned while creating asset of storage type CSV");
        }
        if(createAsset.hasChildType(FieldDelimiter.class)) {
            json.put("fieldDelimiter", createAsset.getChildType(FieldDelimiter.class, 0).getChildType(IdentifierNode.class, 0).getValue().trim());
        }
        if(createAsset.hasChildType(RecordDelimiter.class)) {
            json.put("recordDelimiter", createAsset.getChildType(RecordDelimiter.class, 0).getChildType(IdentifierNode.class, 0).getValue().trim());
        }
        saveSchemaInDB(asset, json);
    }
    
    public void executeDropAsset() {
        if (!logicalPlan.getType().equals(SQLType.DROP_ASSET)) {
            throw new BlkchnException("Statement executed is not of type 'DROP ASSET'");
        }
        TreeNode dropAsset = logicalPlan.getDropAsset();
        String asset = dropAsset.getChildType(Asset.class, 0).getChildType(IdentifierNode.class, 0).getValue().trim();
        removeSchemaInDB(asset);
    }
    
    public String getSchemaJSON(String asset) throws SQLException {
        String schemaJSON;
        String query = "SELECT schema_json FROM asset_schema WHERE asset_name='%s'";
        Connection conn = getConnection();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(String.format(query, asset));
        if(rs.next()) {
            schemaJSON = rs.getString("schema_json");
        } else {
            throw new BlkchnException(String.format("Schema for Asset %s doesn't exist", asset));
        }
        return schemaJSON;
    }
    
    private void saveSchemaInDB(String asset, JSONObject json) {
        String query = "INSERT INTO asset_schema (asset_name, schema_json) VALUES('%s', '%s')";
        try {
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
            stat.execute(String.format(query, asset, json.toJSONString()));
        } catch (SQLException e) {
            LOGGER.error("Error inserting asset type " + asset + " into database", e);
            throw new BlkchnException("Error inserting asset type " + asset + " into database", e);
        }
    }
    
    private void removeSchemaInDB(String asset) {
        String query = "DELETE FROM asset_schema WHERE asset_name='%s'";
        try {
            Connection conn = getConnection();
            Statement stat = conn.createStatement();
            stat.execute(String.format(query, asset));
        } catch (SQLException e) {
            LOGGER.error("Error deleting asset type " + asset + " from database", e);
            throw new BlkchnException("Error deleting asset type " + asset + " from database", e);
        }
    }
    
    private Connection getConnection() throws SQLException {
        StringBuilder sb = new StringBuilder();
        Properties props = getDBProperties();
        if(props.isEmpty()) {
            throw new BlkchnException("Error reading db config file");
        }
        sb.append("jdbc:mysql://");
        sb.append(props.get("host") + ":" + props.getProperty("port") + "/");
        sb.append(props.get("database"));
        String jdbcUrl = sb.toString();
        return DriverManager.getConnection(jdbcUrl, props.getProperty("username"), props.getProperty("password"));
    }

    public abstract Properties getDBProperties();

}
