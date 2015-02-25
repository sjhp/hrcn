/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.cache;

import com.gooday.hrcn.common.cache.model.CacheObject;
import com.gooday.hrcn.common.exception.CacheException;

/**
 * [缓存接口]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/10 21:50]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/10]
 * @Version: [v1.0]
 */
public interface ICache<T> {
    /**
     * 存入数据，返回缓存编号
     * @param data
     * @return
     * @throws CacheException
     */
    String add(T data);

    String add(CacheObject<T> cacheObject);

    /**
     * 根据编号删除缓存
     * @param cacheNo
     * @throws CacheException
     */
    void remove(String cacheNo);
    /**
     * 获取缓存数据
     * @param cacheNo
     * @return
     * @throws CacheException
     */
    T get(String cacheNo);

    <T> CacheObject<T> get();
}
