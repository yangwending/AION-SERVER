package com.aionstar.game.dao;

import com.aionstar.commons.datasource.BaseDao;
import com.aionstar.game.dao.mapper.PlayerMapper;
import com.aionstar.game.model.entity.Player;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author saltman155
 * @date 2019/10/24 2:56
 */

public class PlayerDao extends BaseDao implements PlayerMapper {


    public PlayerDao(SqlSessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Integer getPlayerCount(Integer accountId) {
        try {
            PlayerMapper mapper = getMapperInstance(PlayerMapper.class);
            return mapper.getPlayerCount(accountId);
        } finally {
            close();
        }
    }
}
