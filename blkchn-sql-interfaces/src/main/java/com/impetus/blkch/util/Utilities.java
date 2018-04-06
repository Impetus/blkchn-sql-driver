package com.impetus.blkch.util;

import com.impetus.blkch.sql.query.Column;
import com.impetus.blkch.sql.query.FunctionNode;
import com.impetus.blkch.sql.query.IdentifierNode;
import com.impetus.blkch.sql.query.StarNode;

public class Utilities {

    public static String unquote(String value) {
        if(value.startsWith("'") || value.startsWith("\"")) {
            return value.substring(1, value.length() - 1);
        } else {
            return value;
        }
    }
    
    public static String createFunctionColName(FunctionNode function) {
        String func = function.getChildType(IdentifierNode.class, 0).getValue();
        if (function.hasChildType(FunctionNode.class)) {
            return func + "(" + createFunctionColName(function.getChildType(FunctionNode.class, 0)) + ")";
        } else {
            if (function.hasChildType(StarNode.class))
                return func + "(*)";
            else {
                String colName = function.getChildType(Column.class, 0).getChildType(IdentifierNode.class, 0)
                        .getValue();
                return func + "(" + colName + ")";
            }
        }
    }
}
