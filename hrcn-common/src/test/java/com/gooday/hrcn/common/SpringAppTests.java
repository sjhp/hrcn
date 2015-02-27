package com.gooday.hrcn.common;

import com.gooday.hrcn.common.remoting.netty.NettyClient;
import com.gooday.hrcn.common.remoting.netty.NettyServer;
import com.gooday.hrcn.common.util.LogUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringAppTests {
    @Test
    public void testNettyServer() throws Exception{
        NettyServer server = new NettyServer();
        server.start(8000);
        LogUtil.debug("server started");
    }
    @Test
    public void testNettyClient() throws Exception{
        NettyClient client = new NettyClient();
        client.connect("127.0.0.1",8000);
        LogUtil.debug("start connect");
    }
}
