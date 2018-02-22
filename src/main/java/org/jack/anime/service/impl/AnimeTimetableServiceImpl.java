/**
 * 
 */
package org.jack.anime.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.beanutils.BeanUtils;
import org.jack.anime.common.dataMapping.AutoMapper;
import org.jack.anime.dao.AnimeTimetableMapper;
import org.jack.anime.entity.AnimeTimetable;
import org.jack.anime.service.api.AnimeTimetableService;
import org.jack.anime.service.vo.animeTimetable.AnimeTimetableDto;
import org.jack.anime.service.vo.animeTimetable.AnimeTimetableVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author jack
 *
 */
@Service("animeTimetableService")
public class AnimeTimetableServiceImpl implements AnimeTimetableService {

	private static final Logger logger = LoggerFactory.getLogger(AnimeTimetableServiceImpl.class);

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Resource(name = "animeTimetableMapper")
	AnimeTimetableMapper animeTimetableMapper;

	@Override
	public Integer countAnime() {
		Integer result = (Integer) animeTimetableMapper.totalItem();
		return result;
	}

	@Override
	public Integer save(AnimeTimetableDto dto) {
		Set<ConstraintViolation<AnimeTimetableDto>> set = this.validator.validate(dto, AnimeTimetableDto.Save.class);
		for (ConstraintViolation<AnimeTimetableDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		return null;
	}

	@Override
	public Integer modify(AnimeTimetableDto dto) {
		Set<ConstraintViolation<AnimeTimetableDto>> set = this.validator.validate(dto, AnimeTimetableDto.Save.class);
		for (ConstraintViolation<AnimeTimetableDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		return null;
	}

	@Override
	public PageInfo<AnimeTimetableVo> getListpager(Map<String, Object> params, Integer startRow, Integer pageSize) {
		startRow = startRow == null ? 1 : startRow;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(startRow, pageSize);

		List<AnimeTimetable> list = animeTimetableMapper.getListpager(params);

		List<AnimeTimetableVo> result = new ArrayList<AnimeTimetableVo>();
		if (list != null && list.size() > 0) {
			for (AnimeTimetable animeTimetable : list) {
				try {
					AnimeTimetableVo vo = AnimeTimetableVo.class.newInstance();
					AutoMapper.mapping(animeTimetable, vo);
					result.add(vo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PageInfo<AnimeTimetableVo> page = new PageInfo<>(result);
		return page;
	}

	@Override
	public AnimeTimetableVo getById(Integer id) {
		AnimeTimetableVo ret = null;
		if (id == null) {
			return null;
		}
		AnimeTimetable po = animeTimetableMapper.selectByPrimaryKey(id);
		if (po == null) {
			return null;
		}
		try {
			ret = AnimeTimetableVo.class.newInstance();
			BeanUtils.copyProperties(ret, po);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Boolean delete(Integer id) {
		AnimeTimetable po = animeTimetableMapper.selectByPrimaryKey(id);
		if (po == null) {
			return Boolean.TRUE;
		}
		animeTimetableMapper.deleteByPrimaryKey(id);
		return Boolean.TRUE;
	}

}
