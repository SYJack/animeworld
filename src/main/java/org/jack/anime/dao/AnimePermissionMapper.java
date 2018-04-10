package org.jack.anime.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jack.anime.entity.AnimePermission;
import org.jack.anime.entity.AnimeUser;
import org.springframework.stereotype.Repository;

@Repository("animePermissionMapper")
public interface AnimePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnimePermission record);

    int insertSelective(AnimePermission record);

    AnimePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnimePermission record);

    int updateByPrimaryKey(AnimePermission record);
    
    int totalItem();
    
    List<AnimeUser> getListpager(@Param("params")Map<String,Object> params);
}