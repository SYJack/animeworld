/**
 * 
 */
package org.jack.anime.service.impl;

import javax.annotation.Resource;

import org.jack.anime.dao.AnimeTimetableMapper;
import org.jack.anime.service.IAnimeTimetableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author jack
 *
 */
@Service("animeTimetableService")
public class AnimeTimetableServiceImpl implements IAnimeTimetableService {
	
	 private static final Logger logger = LoggerFactory.getLogger(AnimeTimetableServiceImpl.class);
	 
	 @Resource(name="animeTimetableMapper")
	 AnimeTimetableMapper animeTimetableMapper;

	@Override
	public Long countAnime() {
		Long result = animeTimetableMapper.totalItem();
		if (result == null) {
			logger.error("统计番剧总数失败！");
		}
		return result;
	}
	 
}
