/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.collect.thread;

import com.gooday.hrcn.common.util.LogUtil;

/**
 * [负责文件日志信息主动收集]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/11 0:06]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/11]
 * @Version: [v1.0]
 */
public class FileLogCollectThread extends CollectThread {
    @Override
    public void run() {
        int idx = 0;
        while (true) {
            try {
                Thread.sleep(2000);
                String s = "2015-02-14 this is the log no888=" + idx++;
                LogUtil.debug("data:"+s);
                //收集
                collector.collect(s);
            } catch (Exception ex) {
                ex.printStackTrace();
                LogUtil.sendErr(ex);
            }
        }
    }
}
