/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.event;

import com.gooday.hrcn.common.constant.EnumEventType;

/**
 * [事件,避免耦合，不需要传递事件源]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/11 0:28]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/11]
 * @Version: [v1.0]
 */
public abstract class Event<T>{
    private EnumEventType eventType;
    private T eventObject;
    //private Object eventSource;
    public Event() {
        super();
    }
    public Event(EnumEventType eventType, T obj) {
        this.eventType = eventType;
        this.eventObject = obj;
    }

    public EnumEventType getEventType() {
        return eventType;
    }

    public T getEventObject() {
        return eventObject;
    }

    public void setEventType(EnumEventType eventType) {
        this.eventType = eventType;
    }

    public void setEventObject(T eventObject) {
        this.eventObject = eventObject;
    }


}
