package com.simulator.xslc.connet.intilizer;

import com.simulator.xslc.connet.codec.IecMessageDecoder;
import com.simulator.xslc.connet.codec.IecMessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @auth zme on 2019/3/6 17:55
 **/
public class IecChannelIntilizer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IecMessageDecoder());
        pipeline.addLast(new IecMessageEncoder());

    }
}
