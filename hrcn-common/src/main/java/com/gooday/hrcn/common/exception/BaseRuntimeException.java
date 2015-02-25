/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.exception;

/**
 * [异常父类]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/10 22:05]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/10]
 * @Version: [v1.0]
 */
public class BaseRuntimeException extends RuntimeException{
    public BaseRuntimeException(String msg){
        super(msg);
    }
}
