package org.jack.anime.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jack.anime.entity.AnimeRole;
import org.jack.anime.entity.AnimeUser;
import org.springframework.stereotype.Repository;

@Repository("animeRoleMapper")
public interface AnimeRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnimeRole record);

    int insertSelective(AnimeRole record);

    AnimeRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnimeRole record);

    int updateByPrimaryKey(AnimeRole record);
    
    int totalItem();
    
    List<AnimeRole> getListpager(@Param("params")Map<String,Object> params);
}