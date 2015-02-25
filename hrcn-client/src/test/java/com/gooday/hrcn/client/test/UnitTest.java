/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.client.test;
import com.gooday.hrcn.client.bootstrap.ClientBootStrap;
import com.gooday.hrcn.common.collect.ICollector;
import com.gooday.hrcn.common.context.RuntimeContext;
import org.junit.Test;
/**
 * [简短描述该类的功能]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/15 15:50]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/15]
 * @Version: [v1.0]
 */
public class UnitTest {
    @Test
    public void testCollector() {
        ClientBootStrap bootstrap = new ClientBootStrap();
        bootstrap.init();

        ICollector collector = RuntimeContext.getDataCollector();
        collector.collect("2015-02-18 unittest");
    }
}
