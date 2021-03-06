package com.aionstar.game.network.loginserver.clientpackets;

import com.aionstar.commons.network.packet.ClientPacket;
import com.aionstar.game.config.datasource.DaoManager;
import com.aionstar.game.dao.PlayerDao;
import com.aionstar.game.network.loginserver.serverpackets.SM_GS_CHARACTER;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

/**
 * 账号角色数量查询封包
 * 该数据包对应登录服务器 ${@link com.aionstar.login.network.mainserver.serverpackets.SM_CHARACTER} 包
 * @author saltman155
 * @date 2020/1/22 22:47
 */

public class CM_GS_CHARACTER extends ClientPacket {

    private int accountId;

    public CM_GS_CHARACTER(byte opcode, Channel channel, ByteBuf data) {
        super(opcode, channel, data);
    }

    @Override
    protected void handler() {
        int count = DaoManager.getDao(PlayerDao.class).getPlayerCount(accountId);
        //回传账号包含的用户数给登录服务器
        channel.writeAndFlush(new SM_GS_CHARACTER(accountId,count));
    }

    @Override
    protected void readData() {
        accountId = data.readIntLE();
    }
}
