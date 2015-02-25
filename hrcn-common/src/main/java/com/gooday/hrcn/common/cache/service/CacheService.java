/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.cache.service;

import com.gooday.hrcn.common.cache.ICache;
import com.gooday.hrcn.common.cache.model.CacheObject;
import com.gooday.hrcn.common.constant.EnumCacheType;
import com.gooday.hrcn.common.context.RuntimeContext;
import com.gooday.hrcn.common.event.*;
import com.gooday.hrcn.common.event.manager.EventManager;
import com.gooday.hrcn.common.exception.CacheException;
import com.gooday.hrcn.common.util.GuidGenerator;
import com.gooday.hrcn.common.util.LogUtil;
import com.gooday.hrcn.common.util.StringUtil;
import com.gooday.hrcn.common.util.ValidUtil;

import java.util.*;

/**
 * [缓存管理代理类]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/14 21:23]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/14]
 * @Version: [v1.0]
 */
public class CacheService implements IEventHandler {
    /**
     * 存储
     */
    private ICache cache;
    private Map cacheStore = new HashMap<>();

    public CacheService(ICache cache) {
        this.cache = cache;
    }

    public String add(EnumCacheType cacheType, CacheObject<String> cacheObject) {
        if (cacheObject == null) {
            throw new IllegalArgumentException();
        }
        if (ValidUtil.isEmpty(cacheObject.getCacheNo())) {
            return add(cacheType, cacheObject.getData());
        } else {
            Vector lst = (Vector) cacheStore.getOrDefault(cacheType, new Vector<>());
            lst.add(cacheObject);
            cacheStore.put(cacheType, lst);
            LogUtil.debug(StringUtil.join("Receive and save data ", cacheObject.getCacheNo(), " successful"));
            //发送事件
            dispatch(cacheType);
        }
        return null;
    }

    public String add(EnumCacheType cacheType, String data) {
        if (!ValidUtil.isEmpty(data)) {
            try {
                //String cacheNo = cache.add(data);
                String cacheNo = GuidGenerator.getGUID();
                CacheObject obj = new CacheObject();
                obj.setData(data);
                obj.setCacheNo(cacheNo);
                Vector lst = (Vector) cacheStore.getOrDefault(cacheType, new Vector<>());
                lst.add(obj);
                cacheStore.put(cacheType, lst);
                LogUtil.debug(StringUtil.join("Receive and save data ", cacheNo, " successful"));
                //发送事件
                dispatch(cacheType);
            } catch (CacheException e) {
                LogUtil.sendErr(e);
                throw e;
            }
        }
        return null;
    }

    public void remove(EnumCacheType cacheType, String cacheNo) {
        Vector<CacheObject> lst = (Vector) cacheStore.get(cacheType+"send");
        Iterator<CacheObject> iter = lst.iterator();
        while(iter.hasNext()){
            if(iter.next().getCacheNo().equals(cacheNo)){
                iter.remove();
            }
        }
        /*
        for (CacheObject obj : lst) {
            if (obj.getCacheNo().equals(cacheNo)) {
                lst.remove(obj);
                break;
            }
        }*/
        cacheStore.put(cacheType+"send", lst);
        LogUtil.debug(StringUtil.join(cacheNo, " removed!"));
    }

    /**
     * 发送信息到达事件
     */
    public void dispatch(EnumCacheType cacheType) {
        Vector<CacheObject> lst = (Vector) cacheStore.getOrDefault(cacheType, new Vector<>());
        EventManager em = RuntimeContext.getEventManager();
        LogUtil.debug("===============hellOP:" + lst.size() + cacheType.name());
        Iterator<CacheObject> iter = lst.iterator();
        while(iter.hasNext()){
            CacheObject obj = iter.next();
            Event event;
            switch (cacheType) {
                case CACHE_SEND:
                    event = new SendEvent();
                    break;
                case CACHE_EXPORT:
                    event = new ExportEvent();
                    break;
                default:
                    event = new CollectEvent();
            }
            event.setEventObject(obj);

            Vector<CacheObject> lst1 = (Vector) cacheStore.getOrDefault(cacheType+"send", new Vector<>());
            lst1.add(obj);
            cacheStore.put(cacheType+"send",lst1);

            iter.remove();
            em.dispatchEvent(event);

        }
    }

    @Override
    public void handle(Event event) {
        LogUtil.debug("Ack:" + event.getEventType().toString());
        try {
            AckEvent evt = (AckEvent) event;
            remove(evt.getAckSource(), ((CacheObject) event.getEventObject()).getCacheNo());
        } catch (Exception ex) {
            LogUtil.sendErr(ex);
        }
    }
}
