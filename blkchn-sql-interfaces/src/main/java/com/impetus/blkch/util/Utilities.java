package com.impetus.blkch.util;

public class Utilities {

    public static String unquote(String value) {
        if(value.startsWith("'") || value.startsWith("\"")) {
            return value.substring(1, value.length() - 1);
        } else {
            return value;
        }
    }
}
