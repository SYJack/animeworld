package org.jack.anime.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jack.anime.entity.AnimeManager;
import org.springframework.stereotype.Repository;

@Repository("animeManagerMapper")
public interface AnimeManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnimeManager record);

    int insertSelective(AnimeManager record);

    AnimeManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnimeManager record);

    int updateByPrimaryKey(AnimeManager record);
    
    int totalItem();
    
    List<AnimeManager> getListpager(@Param(value = "params") Map<String,Object> params);
}