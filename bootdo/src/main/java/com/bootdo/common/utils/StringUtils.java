package com.bootdo.common.utils;

/**
 * @author bootdo
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{
    public static String obj2String(Object obj) {
        return null == obj ? "" : obj.toString();
    }

    public static String obj2String(Object obj,String defaultValue) {
        return null == obj ? defaultValue : obj.toString();
    }
}
