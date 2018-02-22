package org.jack.anime.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.jack.anime.entity.AnimeTimetable;
import org.springframework.stereotype.Repository;

@Repository("animeTimetableMapper")
public interface AnimeTimetableMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(AnimeTimetable record);

    int insertSelective(AnimeTimetable record);

    AnimeTimetable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnimeTimetable record);

    int updateByPrimaryKeyWithBLOBs(AnimeTimetable record);

    int updateByPrimaryKey(AnimeTimetable record);
    
    int totalItem();
    
    List<AnimeTimetable> getListpager(@Param(value = "params") Map<String,Object> params);
}