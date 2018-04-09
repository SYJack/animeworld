package org.jack.anime.dao;

import org.jack.anime.entity.AnimeManager;

public interface AnimeManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnimeManager record);

    int insertSelective(AnimeManager record);

    AnimeManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnimeManager record);

    int updateByPrimaryKey(AnimeManager record);
}