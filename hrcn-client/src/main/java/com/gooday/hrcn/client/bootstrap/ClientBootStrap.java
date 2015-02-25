/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.client.bootstrap;

import com.gooday.hrcn.collect.factory.CollectorFactory;
import com.gooday.hrcn.collect.handler.CollectEventHandler;
import com.gooday.hrcn.collect.impl.DefaultDataCollector;
import com.gooday.hrcn.collect.thread.CollectThread;
import com.gooday.hrcn.common.InstanceManager;
import com.gooday.hrcn.common.cache.ICache;
import com.gooday.hrcn.common.cache.service.CacheService;
import com.gooday.hrcn.common.config.ConfigService;
import com.gooday.hrcn.common.constant.Constants;
import com.gooday.hrcn.common.constant.EnumEventType;
import com.gooday.hrcn.common.context.RuntimeContext;
import com.gooday.hrcn.common.event.manager.EventManager;
import com.gooday.hrcn.common.util.LogUtil;
import com.gooday.hrcn.common.util.StringUtil;
import com.gooday.hrcn.common.util.ValidUtil;

import java.util.concurrent.Executors;

/**
 * [简短描述该类的功能]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/14 21:49]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/14]
 * @Version: [v1.0]
 */
public class ClientBootStrap {
    public boolean init() {
        //初始化config
        ConfigService configService = new ConfigService();
        if (!configService.init()) {
            LogUtil.err("Config init fail!");
            return false;
        }
        //放入context
        RuntimeContext.setConfigService(configService);

        //初始化cache
        String cacheClazz = configService.getString(Constants.CLASS_CACHE_IMPL_KEY);
        CacheService cacheService = null;
        try {
            ICache cache = InstanceManager.createInstance(cacheClazz);
            cacheService = new CacheService(cache);

            //放入context
            RuntimeContext.setCacheService(cacheService);
        }catch (Exception ex){
            LogUtil.err(ex);
            return false;
        }

        //初始化eventManager
        EventManager em = new EventManager();
        em.addListener(EnumEventType.COLLECT_EVENT,new CollectEventHandler());
        em.addListener(EnumEventType.ACK_EVENT,cacheService);
        RuntimeContext.setEventManager(em);

        //初始化collector
        DefaultDataCollector collector = new DefaultDataCollector(cacheService);
        //放入context
        RuntimeContext.setDataCollector(collector);
        return true;
    }

    /**
     * 作为app调用的时候，启动
     */
    public void start(){
        //初始化collectors 并启动
        try {
            CollectThread thread = new CollectorFactory().create("com.gooday.hrcn.collect.thread.FileLogCollectThread");
            Executors.newSingleThreadExecutor().submit(thread);
        } catch (Exception ex) {
            LogUtil.err(ex);
            throw new RuntimeException(StringUtil.join("Start failed due to:",ex.getMessage()));
        }
    }
}
