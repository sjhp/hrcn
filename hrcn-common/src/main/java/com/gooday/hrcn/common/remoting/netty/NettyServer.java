/*
 * 巨商汇平台 版权所有 Copyright@2014
 */
package com.gooday.hrcn.common.remoting.netty;

import com.gooday.hrcn.common.remoting.netty.handler.NettyServerInHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * [netty server功能]
 *
 * @ProjectName: [hrcn]
 * @Author: [tophawk]
 * @CreateDate: [2015/2/11 11:36]
 * @Update: [说明本次修改内容] BY[tophawk][2015/2/11]
 * @Version: [v1.0]
 */
public class NettyServer {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 8000;
    /**用于分配处理业务线程的线程组个数 */
    protected static final int REACTOR_SIZE = Runtime.getRuntime().availableProcessors()*2; //默认处理器*2
    /** 业务处理线程数量*/
    protected static final int WORKER_SIZE = 4;

    public void start(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(REACTOR_SIZE);
        EventLoopGroup workerGroup = new NioEventLoopGroup(WORKER_SIZE);
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            // Decoders
                            //channel.pipeline().addLast("frameDecoder", new LineBasedFrameDecoder(80));
                            channel.pipeline().addLast("stringDecoder", new StringDecoder(CharsetUtil.UTF_8));

                            // Encoder
                            channel.pipeline().addLast("stringEncoder", new StringEncoder(CharsetUtil.UTF_8));

                            //注册handler
                            channel.pipeline().addLast(new NettyServerInHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

            ChannelFuture f = bootstrap.bind(port).sync();

            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
