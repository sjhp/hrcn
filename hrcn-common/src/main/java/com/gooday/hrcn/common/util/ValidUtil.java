package com.gooday.hrcn.common.util;

/**
 * 临时工具类
 *
 * @author
 * @since 1.0
 */
public class ValidUtil {

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.trim().equals("")) return true;
        return false;
    }

}
