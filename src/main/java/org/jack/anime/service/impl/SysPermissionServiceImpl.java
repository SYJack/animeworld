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
import org.jack.anime.dao.AnimePermissionMapper;
import org.jack.anime.entity.AnimePermission;
import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.SysPermissionService;
import org.jack.anime.service.vo.animePermission.AnimePermissionDto;
import org.jack.anime.service.vo.animePermission.AnimePermissionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author jack
 *
 */
@Service("sysPermissionServiceImpl")
public class SysPermissionServiceImpl implements SysPermissionService {

	private static final Logger logger = LoggerFactory.getLogger(SysPermissionServiceImpl.class);

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Resource(name = "animePermissionMapper")
	private AnimePermissionMapper animePermissionMapper;

	@Override
	public Integer countPermission() {
		Integer result = (Integer) animePermissionMapper.totalItem();
		return result;
	}

	@Override
	public Integer save(AnimePermissionDto dto) {
		Set<ConstraintViolation<AnimePermissionDto>> set = this.validator.validate(dto, AnimePermissionDto.Save.class);
		for (ConstraintViolation<AnimePermissionDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		Integer result = null;
		if(dto == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		try {
			AnimePermission po = AnimePermission.class.newInstance();
			AutoMapper.mapping(dto, po);
			result = animePermissionMapper.insert(po);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return result;
	}

	@Override
	public Boolean modify(AnimePermissionDto dto) {
		Set<ConstraintViolation<AnimePermissionDto>> set = this.validator.validate(dto, AnimePermissionDto.Modify.class);
		for (ConstraintViolation<AnimePermissionDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		if(dto == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		AnimePermissionVo vo = this.getById(dto.getId());
		if(vo == null){
			logger.error("modify:权限信息未持久化");
			throw new RuntimeException("权限信息未持久化");
		}
		try {
			AnimePermission po = AnimePermission.class.newInstance();
			AutoMapper.mapping(dto,po);
			animePermissionMapper.updateByPrimaryKeySelective(po);
			return Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public AnimePermissionVo getById(Integer id) {
		AnimePermissionVo vo = null;
		if (id == null) {
			return null;
		}
		AnimePermission po = animePermissionMapper.selectByPrimaryKey(id);
		if (po == null) {
			return null;
		}
		try {
			vo = AnimePermissionVo.class.newInstance();
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
		AnimePermission po = animePermissionMapper.selectByPrimaryKey(id);
		if (po == null) {
			logger.error("delete:数据未持久化");
			throw new RuntimeException("数据未持久化");
		}
		animePermissionMapper.deleteByPrimaryKey(id);
		return Boolean.TRUE;
	}

	@Override
	public PageResult<AnimePermissionVo> getListpager(Map<String, Object> params, Integer startRow, Integer pageSize) {
		startRow = startRow == null ? 1 : startRow;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(startRow, pageSize);

		List<AnimePermission> list = animePermissionMapper.getListpager(params);

		PageInfo<AnimePermission> pageInfo = new PageInfo<>(list);
		
		List<AnimePermissionVo> result = new ArrayList<AnimePermissionVo>();
		if (list != null && list.size() > 0) {
			for (AnimePermission po : list) {
				try {
					AnimePermissionVo vo = AnimePermissionVo.class.newInstance();
					AutoMapper.mapping(po, vo);
					result.add(vo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PageResult<AnimePermissionVo> pageResult = new PageResult<AnimePermissionVo>(); 
		pageResult.setPageNo(pageInfo.getPageNum());  
		pageResult.setPageSize(pageInfo.getPageSize());  
		pageResult.setDataList(result);  
		pageResult.setTotal(pageInfo.getTotal());  
		pageResult.setPages(pageInfo.getPages());  
		return pageResult;
	}

}
