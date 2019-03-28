package com.bootdo.common.utils;

import java.util.HashMap;
import java.util.Map;

public enum JdbcType {
    ARRAY("ARRAY"),
    BIT("BIT"),
    TINYINT("SMALLINT"),
    SMALLINT("SMALLINT"),
    INTEGER("INTEGER"),
    BIGINT("BIGINT"),
    FLOAT("FLOAT"),
    REAL("REAL"),
    DOUBLE("DOUBLE"),
    NUMERIC("NUMERIC"),
    DECIMAL("DECIMAL"),
    CHAR("CHAR"),
    VARCHAR("VARCHAR"),
    LONGVARCHAR("LONGVARCHAR"),
    DATE("DATE"),
    TIME("TIME"),
    TIMESTAMP("TIMESTAMP"),
    BINARY("BINARY"),
    VARBINARY("VARBINARY"),
    LONGVARBINARY("LONGVARBINARY"),
    NULL("NULL"),
    OTHER("OTHER"),
    BLOB("BLOB"),
    CLOB("CLOB"),
    BOOLEAN("BOOLEAN"),
    CURSOR("CURSOR"),
    UNDEFINED("UNDEFINED"),
    NVARCHAR("NVARCHAR"),
    NCHAR("NCHAR"),
    NCLOB("NCLOB"),
    STRUCT("STRUCT"),
    JAVA_OBJECT("JAVA_OBJECT"),
    DISTINCT("DISTINCT"),
    REF("REF"),
    DATALINK("DATALINK"),
    ROWID("ROWID"),
    LONGNVARCHAR("LONGNVARCHAR"),
    SQLXML("SQLXML"),
    DATETIMEOFFSET("DATETIMEOFFSET");

    public final String value;

    private JdbcType(String code) {
        this.value = code;
    }

    public String getValue() {
        return value;
    }
}


