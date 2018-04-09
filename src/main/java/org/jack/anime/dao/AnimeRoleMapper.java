package org.jack.anime.dao;

import org.jack.anime.entity.AnimeRole;

public interface AnimeRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnimeRole record);

    int insertSelective(AnimeRole record);

    AnimeRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnimeRole record);

    int updateByPrimaryKey(AnimeRole record);
}