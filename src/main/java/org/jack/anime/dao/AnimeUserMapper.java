package org.jack.anime.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jack.anime.entity.AnimeUser;
import org.springframework.stereotype.Repository;

@Repository("animeUserMapper")
public interface AnimeUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnimeUser record);

    int insertSelective(AnimeUser record);

    AnimeUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnimeUser record);

    int updateByPrimaryKey(AnimeUser record);
    
    int totalItem();
    
    List<AnimeUser> getListpager(@Param(value = "params") Map<String,Object> params);
}