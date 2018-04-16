package org.jack.anime.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jack.anime.entity.RolePerm;
import org.springframework.stereotype.Repository;

@Repository("rolePermMapper")
public interface RolePermMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePerm record);

    int insertSelective(RolePerm record);

    RolePerm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePerm record);

    int updateByPrimaryKey(RolePerm record);
    
    int totalItem();
    
    List<RolePerm> getListpager(@Param("params")Map<String,Object> params);
}