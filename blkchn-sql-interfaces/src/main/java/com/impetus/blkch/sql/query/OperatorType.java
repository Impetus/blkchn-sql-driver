package com.impetus.blkch.sql.query;

public enum OperatorType {

    EQUALS("=="),

    GREATER(">"),

    GREATER_THAN(">="),

    LESSER("<"),

    LESSER_THAN("<="),

    NOT_EQUALS("!=");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }
}
