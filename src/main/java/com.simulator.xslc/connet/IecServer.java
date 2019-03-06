package com.simulator.xslc.connet;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
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
    }

}
