/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.cache.impl;

import com.gooday.hrcn.common.cache.ICache;
import com.gooday.hrcn.common.cache.model.CacheObject;
import com.gooday.hrcn.common.exception.CacheException;
import com.gooday.hrcn.common.util.GuidGenerator;

/**
 * [利用文件进行缓存功能]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/10 22:59]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/10]
 * @Version: [v1.0]
 */
public class FileCache implements ICache<String> {
    @Override
    public String add(String data) throws CacheException {
        return null;
    }

    @Override
    public String add(CacheObject<String> cacheObject) {
        return null;
    }

    @Override
    public void remove(String cacheNo) throws CacheException {

    }

    @Override
    public String get(String cacheNo) throws CacheException {
        return null;
    }

    @Override
    public CacheObject<String> get() throws CacheException {
        CacheObject<String> s = new CacheObject<String>();
        s.setCacheNo(GuidGenerator.getGUID());
        s.setData("hello file cache!");
        return s;
    }
}
