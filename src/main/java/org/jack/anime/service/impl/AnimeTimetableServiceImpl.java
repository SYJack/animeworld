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
import org.jack.anime.entity.PageResult;
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
@Service("animeTimetableServiceImpl")
public class AnimeTimetableServiceImpl implements AnimeTimetableService {

	private static final Logger logger = LoggerFactory.getLogger(AnimeTimetableServiceImpl.class);

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Resource(name = "animeTimetableMapper")
	private AnimeTimetableMapper animeTimetableMapper;

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
		Integer result = null;
		if(dto == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		try {
			AnimeTimetable po = AnimeTimetable.class.newInstance();
			AutoMapper.mapping(dto,po);
			result = animeTimetableMapper.insertSelective(po);
		} catch (Exception e ) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public Boolean modify(AnimeTimetableDto dto) {
		Set<ConstraintViolation<AnimeTimetableDto>> set = this.validator.validate(dto, AnimeTimetableDto.Modify.class);
		for (ConstraintViolation<AnimeTimetableDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		if(dto == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		AnimeTimetableVo vo = this.getById(dto.getId());
		
		if(vo == null){
			logger.error("modify:动漫时间表信息未持久化");
			throw new RuntimeException("动漫时间表信息未持久化");
		}
		
		try {
			AnimeTimetable po = AnimeTimetable.class.newInstance();
			AutoMapper.mapping(dto,po);
			animeTimetableMapper.updateByPrimaryKeySelective(po);
		} catch (Exception e ) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return Boolean.TRUE;
	}

	@Override
	public PageResult<AnimeTimetableVo> getListpager(Map<String, Object> params, Integer startRow, Integer pageSize) {
		startRow = startRow == null ? 1 : startRow;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(startRow, pageSize);

		List<AnimeTimetable> list = animeTimetableMapper.getListpager(params);

		PageInfo<AnimeTimetable> pageInfo = new PageInfo<>(list);
		
		List<AnimeTimetableVo> result = new ArrayList<AnimeTimetableVo>();
		if (list != null && list.size() > 0) {
			for (AnimeTimetable po : list) {
				try {
					AnimeTimetableVo vo = AnimeTimetableVo.class.newInstance();
					AutoMapper.mapping(po, vo);
					result.add(vo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PageResult<AnimeTimetableVo> pageResult = new PageResult<AnimeTimetableVo>(); 
		pageResult.setPageNo(pageInfo.getPageNum());  
		pageResult.setPageSize(pageInfo.getPageSize());  
		pageResult.setDataList(result);  
		pageResult.setTotal(pageInfo.getTotal());  
		pageResult.setPages(pageInfo.getPages());  
		return pageResult;
	}

	@Override
	public AnimeTimetableVo getById(Integer id) {
		AnimeTimetableVo vo = null;
		if (id == null) {
			return null;
		}
		AnimeTimetable po = animeTimetableMapper.selectByPrimaryKey(id);
		if (po == null) {
			return null;
		}
		try {
			vo = AnimeTimetableVo.class.newInstance();
			BeanUtils.copyProperties(vo, po);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public Boolean delete(Integer id) {
		if(id == null)
			return Boolean.FALSE;
		AnimeTimetable po = animeTimetableMapper.selectByPrimaryKey(id);
		if (po == null) {
			logger.error("delete:数据未持久化");
			throw new RuntimeException("数据未持久化");
		}
		animeTimetableMapper.deleteByPrimaryKey(id);
		return Boolean.TRUE;
	}

}
