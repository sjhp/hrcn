/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.cache.model;

/**
 * [缓存对象]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/10 22:46]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/10]
 * @Version: [v1.0]
 */
public class CacheObject<T> {
    private String cacheNo;
    private T data;

    public String getCacheNo() {
        return cacheNo;
    }

    public void setCacheNo(String cacheNo) {
        this.cacheNo = cacheNo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString(){
        return this.getCacheNo().concat("=>").concat(data.toString());
    }
}
