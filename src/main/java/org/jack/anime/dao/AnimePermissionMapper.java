package org.jack.anime.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.jack.anime.entity.AnimePermission;
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
    
    List<AnimePermission> getListpager(@Param("params")Map<String,Object> params);
    
    Set<String> getPermissions(@Param("uId") Integer uId);
}