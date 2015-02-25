/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.collect.handler;

import com.gooday.hrcn.common.cache.ICache;
import com.gooday.hrcn.common.cache.model.CacheObject;
import com.gooday.hrcn.common.cache.service.CacheService;
import com.gooday.hrcn.common.constant.EnumCacheType;
import com.gooday.hrcn.common.constant.EnumEventType;
import com.gooday.hrcn.common.context.RuntimeContext;
import com.gooday.hrcn.common.event.AckEvent;
import com.gooday.hrcn.common.event.Event;
import com.gooday.hrcn.common.event.IEventHandler;
import com.gooday.hrcn.common.event.manager.EventManager;
import com.gooday.hrcn.common.util.LogUtil;

import java.util.HashMap;

/**
 * [处理数据收集事件]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/11 1:10]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/11]
 * @Version: [v1.0]
 */
public class CollectEventHandler implements IEventHandler<CacheObject> {
    @Override
    public void handle(Event<CacheObject> event) {
        if(event.getEventType().equals(EnumEventType.COLLECT_EVENT)){
            LogUtil.debug("collect handler come!");
            CacheObject obj = event.getEventObject();

            LogUtil.debug("consume："+obj.getData());
            //parse 数据

            //send 数据
            try {
                RuntimeContext.getCacheService().add(EnumCacheType.CACHE_SEND, event.getEventObject());
                //发送ack事件
                AckEvent ackEvent = new AckEvent();
                ackEvent.setEventObject(obj);
                ackEvent.setAckSource(EnumCacheType.CACHE_COLLECT);

                RuntimeContext.getEventManager().dispatchEvent(ackEvent);
            }catch (Exception ex){
                LogUtil.err(ex);
            }
        }
    }
}
