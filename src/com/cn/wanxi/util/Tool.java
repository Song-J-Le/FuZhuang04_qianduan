package com.cn.wanxi.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Tool {
    private Tool() {
        Set set =new HashSet();
        Map map=new HashMap();
        map.put("","");
//        set,map的区别？key值是否可以重复，
//        key是否可以为null，value是否可以为null
    }

    /**
     * @param value
     * @return
     */
    public static Integer strToPage(String value) {
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            return 1;
        }

    }

    /**
     * @param value
     * @return
     */
    public static Integer strToLimit(String value) {
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            return 10;
        }

    }

    public static String judgeNull(String value) {
        return value == null ? "" : value;
    }

    /**
     * @param value
     * @return
     */
    public static Integer strToInt(String value) {
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            return -1;
        }

    }

    public static BigDecimal strToBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            return BigDecimal.valueOf(0);
        }

    }
}
