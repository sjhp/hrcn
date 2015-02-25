/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.event;

/**
 * [事件处理类]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/11 1:07]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/11]
 * @Version: [v1.0]
 */
public interface IEventHandler<T> {
    void handle(Event<T> event);
}
