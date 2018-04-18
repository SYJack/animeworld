/**
 * 
 */
package org.jack.anime.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.beanutils.BeanUtils;
import org.jack.anime.common.dataMapping.AutoMapper;
import org.jack.anime.dao.AnimeShiroFilterMapper;
import org.jack.anime.entity.AnimeShiroFilter;
import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.AnimeShiroFilterService;
import org.jack.anime.service.vo.animeShiroFilter.AnimeShiroFilterDto;
import org.jack.anime.service.vo.animeShiroFilter.AnimeShiroFilterVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author jack
 *
 */
@Service("animeShiroFilterServiceImpl")
public class AnimeShiroFilterServiceImpl implements AnimeShiroFilterService {
	
	private static final Logger logger = LoggerFactory.getLogger(AnimeShiroFilterServiceImpl.class);

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@Resource(name = "animeShiroFilterMapper")
	private AnimeShiroFilterMapper animeShiroFilterMapper;

	@Override
	public Integer countFilter() {
		Integer result = (Integer) animeShiroFilterMapper.totalItem();
		return result;
	}

	@Override
	public Integer save(AnimeShiroFilterDto dto) {
		Set<ConstraintViolation<AnimeShiroFilterDto>> set = this.validator.validate(dto, AnimeShiroFilterDto.Save.class);
		for (ConstraintViolation<AnimeShiroFilterDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		Integer result = null;
		if(dto == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		try {
			AnimeShiroFilter po = AnimeShiroFilter.class.newInstance();
			AutoMapper.mapping(dto,po);
			po.setCreateTimestamp(new Date().getTime());
			result = animeShiroFilterMapper.insertSelective(po);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} 
		return result;
	}

	@Override
	public Boolean modify(AnimeShiroFilterDto dto) {
		Set<ConstraintViolation<AnimeShiroFilterDto>> set = this.validator.validate(dto, AnimeShiroFilterDto.Modify.class);
		for (ConstraintViolation<AnimeShiroFilterDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		if(dto == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		try {
			AnimeShiroFilter po = AnimeShiroFilter.class.newInstance();
			AutoMapper.mapping(dto,po);
			animeShiroFilterMapper.updateByPrimaryKeySelective(po);
			return Boolean.TRUE;
		} catch (Exception e ) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public AnimeShiroFilterVo getById(Integer id) {
		AnimeShiroFilterVo vo = null;
		if (id == null) {
			return null;
		}
		AnimeShiroFilter po = animeShiroFilterMapper.selectByPrimaryKey(id);
		if (po == null) {
			return null;
		}
		try {
			vo = AnimeShiroFilterVo.class.newInstance();
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
		AnimeShiroFilter po = animeShiroFilterMapper.selectByPrimaryKey(id);
		if (po == null) {
			logger.error("delete:数据未持久化");
			throw new RuntimeException("数据未持久化");
		}
		animeShiroFilterMapper.deleteByPrimaryKey(id);
		return Boolean.TRUE;
	}

	@Override
	public PageResult<AnimeShiroFilterVo> getListpager(
			Map<String, Object> params, Integer startRow, Integer pageSize) {
		startRow = startRow == null ? 1 : startRow;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(startRow, pageSize);

		List<AnimeShiroFilter> list = animeShiroFilterMapper.getListpager(params);

		PageInfo<AnimeShiroFilter> pageInfo = new PageInfo<>(list);
		
		List<AnimeShiroFilterVo> result = new ArrayList<AnimeShiroFilterVo>();
		if (list != null && list.size() > 0) {
			for (AnimeShiroFilter po : list) {
				try {
					AnimeShiroFilterVo vo = AnimeShiroFilterVo.class.newInstance();
					AutoMapper.mapping(po, vo);
					result.add(vo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PageResult<AnimeShiroFilterVo> pageResult = new PageResult<AnimeShiroFilterVo>(); 
		pageResult.setPageNo(pageInfo.getPageNum());  
		pageResult.setPageSize(pageInfo.getPageSize());  
		pageResult.setDataList(result);  
		pageResult.setTotal(pageInfo.getTotal());  
		pageResult.setPages(pageInfo.getPages());  
		return pageResult;
	}

}
