/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.event.manager;

import com.gooday.hrcn.common.constant.EnumEventType;
import com.gooday.hrcn.common.event.Event;
import com.gooday.hrcn.common.event.IEventHandler;
import com.gooday.hrcn.common.util.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [简短描述该类的功能]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/11 0:30]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/11]
 * @Version: [v1.0]
 */
public class EventManager {
    /**
     * 监听者序列
     */
    private Map<EnumEventType,List<IEventHandler>> listeners;

    public void addListener(EnumEventType type,IEventHandler handler){
        if(listeners == null) listeners = new HashMap<>();
        if(type == null && handler == null)
            throw new IllegalArgumentException("invalid arguments!");
        if(listeners.get(type)==null)
            listeners.put(type,new ArrayList());

        listeners.get(type).add(handler);
    }

    public void dispatchEvent(Event event){
        switch(event.getEventType()){
            case COLLECT_EVENT:
                LogUtil.debug("collect:"+event.getEventObject());

                break;
            case SEND_EVENT:
                LogUtil.debug("send:"+event.getEventObject());
                break;
            case CONFIGUPDATE_EVENT:
                LogUtil.debug("export:"+event.getEventObject());
                break;
            default:
                LogUtil.debug("error:"+event.getEventObject());
        }

        LogUtil.debug("============"+event.getEventType());
        //notify
        List<IEventHandler> lst = listeners.get(event.getEventType());
        if(lst != null){
            for(IEventHandler handler:lst){
                handler.handle(event);
            }
        }
    }
}
