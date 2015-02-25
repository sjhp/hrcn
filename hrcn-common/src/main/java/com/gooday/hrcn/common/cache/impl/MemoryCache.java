/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.cache.impl;

import com.gooday.hrcn.common.cache.ICache;
import com.gooday.hrcn.common.cache.model.CacheObject;
import com.gooday.hrcn.common.exception.CacheException;
import com.gooday.hrcn.common.util.GuidGenerator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * [利用文件进行缓存功能]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/10 22:59]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/10]
 * @Version: [v1.0]
 */
public class MemoryCache implements ICache<String> {
    public static Map<String,String> dataMap = new HashMap<String,String>();

    @Override
    public String add(String data) throws CacheException {
        String uuid = GuidGenerator.getGUID();
        dataMap.put(uuid,data);
        return uuid;
    }

    @Override
    public String add(CacheObject<String> cacheObject) {
        return null;
    }

    @Override
    public void remove(String cacheNo) throws CacheException {
        dataMap.remove(cacheNo);
        System.out.println("after remove:"+dataMap.size());
    }

    @Override
    public String get(String cacheNo) throws CacheException {
        return null;
    }

    @Override
    public CacheObject<String> get() throws CacheException {

        if(dataMap.size()<=0) return null;
        Iterator<Map.Entry<String,String>> iter = dataMap.entrySet().iterator();
        Map.Entry<String,String> entry = iter.next();

        CacheObject<String> s = new CacheObject<String>();
        s.setCacheNo(entry.getKey());
        s.setData(entry.getValue());
        return s;
    }
}
