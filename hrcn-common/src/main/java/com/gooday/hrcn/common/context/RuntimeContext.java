/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.context;

import com.gooday.hrcn.common.cache.service.CacheService;
import com.gooday.hrcn.common.collect.ICollector;
import com.gooday.hrcn.common.config.ConfigService;
import com.gooday.hrcn.common.event.manager.EventManager;
import com.gooday.hrcn.common.util.LogUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * [存储运行时通用数据，可以自定义放置一些运行时全局参数]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/15 10:11]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/15]
 * @Version: [v1.0]
 */
public class RuntimeContext {
    /**
     * 数据存储
     */
    private static final Map<Integer, Object> CONTEXT_DATA = new HashMap<>();
    /**
     * 系统缓存对象
     */
    private static final int CONTEXT_CACHE_SERVICE = 900;
    /**
     * 系统事件管理器
     */
    private static final int CONTEXT_EVENT_MANAGER = 901;
    /**
     * 系统配置管理器
     */
    private static final int CONTEXT_CONFIG_SERVICE = 902;
    /**
     * 系统基础收集器
     */
    private static final int CONTEXT_DEFAULT_COLLECTOR = 903;

    private RuntimeContext() {
    }

    /**
     * 通用取数据方法
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T get(int key) {
        try {
            return (T) CONTEXT_DATA.get(key);
        } catch (Exception ex) {
            ex.printStackTrace();
            LogUtil.err(ex);
        }
        return null;
    }

    public static <T> void set(int key, T obj) {
        CONTEXT_DATA.put(key, obj);
    }

    public static CacheService getCacheService() {
        return get(CONTEXT_CACHE_SERVICE);
    }

    public static void setCacheService(CacheService obj) {
        set(CONTEXT_CACHE_SERVICE, obj);
    }

    public static ConfigService getConfigService() {
        return get(CONTEXT_CONFIG_SERVICE);
    }

    public static void setConfigService(ConfigService obj) {
        set(CONTEXT_CONFIG_SERVICE, obj);
    }

    public static EventManager getEventManager() {
        return get(CONTEXT_EVENT_MANAGER);
    }

    public static void setEventManager(EventManager obj) {
        set(CONTEXT_EVENT_MANAGER, obj);
    }

    public static ICollector getDataCollector() {
        return get(CONTEXT_DEFAULT_COLLECTOR);
    }

    public static void setDataCollector(ICollector obj) {
        set(CONTEXT_DEFAULT_COLLECTOR, obj);
    }
}
