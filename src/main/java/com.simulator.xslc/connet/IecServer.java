package com.simulator.xslc.connet;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;

/**
 * @auth zme on 2019/3/6 17:22
 **/
public class IecServer {
    private static volatile IecServer iecServer;
    private static final Logger LOGGER = Logger.getLogger(IecServer.class);
    private EventLoopGroup bossGroup;
    private EventLoopGroup workGroup;
    private ServerBootstrap serverBootstrap;
    private IecServer(){
        bossGroup = new NioEventLoopGroup(1);
        workGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
    }
    public IecServer getInstance(){
        if(null==iecServer){
            synchronized (IecServer.class){
                if(null == iecServer){
                    iecServer = new IecServer();
                    return iecServer;
                }
            }
        }
        return iecServer;
    }
    public void start(){
        //todo
        serverBootstrap.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_REUSEADDR, true)
                .childOption(ChannelOption.SO_KEEPALIVE, false)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .option(ChannelOption.SO_RCVBUF, 65535)
                .option(ChannelOption.SO_SNDBUF, 65535)
                .childOption(ChannelOption.ALLOCATOR,
                        PooledByteBufAllocator.DEFAULT)
                .childHandler(new IecChannelIntilizer());
    }

}
