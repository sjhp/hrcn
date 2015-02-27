/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.collect.impl;

import com.gooday.hrcn.common.cache.service.CacheService;
import com.gooday.hrcn.common.collect.ICollector;
import com.gooday.hrcn.common.constant.EnumCacheType;
import com.gooday.hrcn.common.exception.CollectException;
import com.gooday.hrcn.common.util.ValidUtil;

/**
 * [简短描述该类的功能]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/14 21:20]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/14]
 * @Version: [v1.0]
 */
public class DefaultDataCollector implements ICollector<String> {
    private CacheService cacheService;

    public DefaultDataCollector() {
    }

    public DefaultDataCollector(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * 加入缓存
     *
     * @param data
     * @throws CollectException
     */
    @Override
    public void collect(String data) throws CollectException {
        if (!ValidUtil.isEmpty(data)) {
            cacheService.add(EnumCacheType.CACHE_COLLECT,data);
        }
    }
}
