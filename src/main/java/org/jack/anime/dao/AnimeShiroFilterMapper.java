package org.jack.anime.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jack.anime.entity.AnimeShiroFilter;
import org.springframework.stereotype.Repository;

@Repository("animeShiroFilterMapper")
public interface AnimeShiroFilterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnimeShiroFilter record);

    int insertSelective(AnimeShiroFilter record);

    AnimeShiroFilter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnimeShiroFilter record);

    int updateByPrimaryKey(AnimeShiroFilter record);
    
    int totalItem();
    
    List<AnimeShiroFilter> getListpager(@Param("params")Map<String,Object> params);
}