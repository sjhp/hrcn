/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.event;

import com.gooday.hrcn.common.constant.EnumEventType;

/**
 * [系统运行状态变化事件,避免耦合，不需要传递事件源]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/11 0:28]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/11]
 * @Version: [v1.0]
 */
public class StatusEvent extends Event {
    public StatusEvent() {
        setEventType(EnumEventType.STATUS_EVENT);
    }
}
