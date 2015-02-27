/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.collect.factory;


import com.gooday.hrcn.collect.thread.CollectThread;
import com.gooday.hrcn.common.InstanceManager;
import com.gooday.hrcn.common.collect.ICollector;
import com.gooday.hrcn.common.context.RuntimeContext;
import com.gooday.hrcn.common.util.LogUtil;
import com.gooday.hrcn.common.util.StringUtil;
import com.gooday.hrcn.common.util.ValidUtil;

/**
 * [负责创建collectors]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/14 13:15]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/14]
 * @Version: [v1.0]
 */
public class CollectorFactory {
    /**
     * 创建主动收集型的collector
     *
     * @param clazz
     * @return
     */
    public CollectThread create(String clazz) {
        if (ValidUtil.isEmpty(clazz)) {
            throw new IllegalArgumentException(StringUtil.join("Invalid class name: ", clazz));
        }
        try {
            ICollector collector = RuntimeContext.getDataCollector();

            CollectThread collectThread = InstanceManager.createInstance(clazz);
            collectThread.setCollector(collector);

            return collectThread;
        } catch (Exception e) {
            LogUtil.sendErr(e);
            throw new IllegalStateException(StringUtil.join("class ", clazz, " not found!"));
        }
    }
}
