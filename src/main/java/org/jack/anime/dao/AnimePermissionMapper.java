package org.jack.anime.dao;

import org.jack.anime.entity.AnimePermission;

public interface AnimePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnimePermission record);

    int insertSelective(AnimePermission record);

    AnimePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnimePermission record);

    int updateByPrimaryKey(AnimePermission record);
}