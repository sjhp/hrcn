/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.event;

import com.gooday.hrcn.common.constant.EnumCacheType;
import com.gooday.hrcn.common.constant.EnumEventType;

/**
 * [确认事件,避免耦合，不需要传递事件源]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/11 0:28]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/11]
 * @Version: [v1.0]
 */
public class AckEvent extends Event {
    private EnumCacheType ackSource;

    public EnumCacheType getAckSource() {
        return ackSource;
    }

    public void setAckSource(EnumCacheType ackSource) {
        this.ackSource = ackSource;
    }

    public AckEvent() {
        setEventType(EnumEventType.ACK_EVENT);
    }
}
