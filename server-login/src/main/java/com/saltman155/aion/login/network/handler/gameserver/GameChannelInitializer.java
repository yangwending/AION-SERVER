package com.saltman155.aion.login.network.handler.gameserver;

import com.saltman155.aion.login.network.handler.PacketFrameDecoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录服务器连接游戏服务器
 * @author saltman155
 * @date 2019/10/24 3:47
 */

@Component
public class GameChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Resource
    private GameChannelHandler gameChannelHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //入站Frame编码器
        pipeline.addLast(new PacketFrameDecoder());
        //主服务端封包处理器
        pipeline.addLast(gameChannelHandler);
    }

}