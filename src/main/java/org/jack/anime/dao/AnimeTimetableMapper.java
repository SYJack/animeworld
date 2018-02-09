package org.jack.anime.dao;

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
    
    long totalItem();
}