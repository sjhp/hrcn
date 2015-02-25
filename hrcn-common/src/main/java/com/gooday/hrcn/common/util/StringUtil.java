/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.util;

/**
 * [简短描述该类的功能]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/14 20:55]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/14]
 * @Version: [v1.0]
 */
public class StringUtil {
    /**
     * 字符串连接，避免加号的滥用
     *
     * @param params
     * @return
     */
    public static String join(String... params) {
        StringBuffer buffer = new StringBuffer();
        for (String item : params) {
            buffer.append(item);
        }
        return buffer.toString();
    }
}
