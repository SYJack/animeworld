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
import org.jack.anime.dao.AnimeManagerMapper;
import org.jack.anime.dao.AnimeRoleMapper;
import org.jack.anime.dao.AnimeUserMapper;
import org.jack.anime.entity.AnimeManager;
import org.jack.anime.entity.AnimeRole;
import org.jack.anime.entity.AnimeUser;
import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.SysManagerService;
import org.jack.anime.service.vo.animeManager.AnimeManagerDto;
import org.jack.anime.service.vo.animeManager.AnimeManagerVo;
import org.jack.anime.service.vo.animeUser.AnimeUserDto;
import org.jack.anime.service.vo.animeUser.AnimeUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("sysManagerServiceImpl")
public class SysManagerServiceImpl implements SysManagerService {

	private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Resource(name = "animeManagerMapper")
	private AnimeManagerMapper animeManagerMapper;
	
	@Resource(name = "animeUserMapper")
	private AnimeUserMapper animeUserMapper;
	
	@Resource(name = "animeRoleMapper")
	private AnimeRoleMapper animeRoleMapper;
	
	@Override
	public Integer countManager() {
		Integer result = (Integer) animeManagerMapper.totalItem();
		return result;
	}

	@Override
	public Integer save(AnimeManagerDto dto) {
		Set<ConstraintViolation<AnimeManagerDto>> set = this.validator.validate(dto, AnimeManagerDto.Save.class);
		for (ConstraintViolation<AnimeManagerDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		Integer result = null;
		if(dto == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		AnimeUser animeUser = this.animeUserMapper.selectByPrimaryKey(dto.getCustomerId());
		if(animeUser == null){
			logger.error("save:用户未持久化");
			throw new RuntimeException("用户未持久化");
		}
		AnimeRole animeRole = this.animeRoleMapper.selectByPrimaryKey(dto.getRoleId());
		if(animeRole == null){
			logger.error("save:角色未持久化");
			throw new RuntimeException("角色未持久化");
		}
		try {
			AnimeManager po = AnimeManager.class.newInstance();
			AutoMapper.mapping(dto,po);
			po.setCreateTimestamp(new Date().getTime());
			result = animeManagerMapper.insertSelective(po);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} 
		return result;
	}

	@Override
	public Boolean modify(AnimeManagerDto dto) {
		Set<ConstraintViolation<AnimeManagerDto>> set = this.validator.validate(dto, AnimeManagerDto.Modify.class);
		for (ConstraintViolation<AnimeManagerDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		if(dto == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		AnimeManagerVo vo = this.getById(dto.getId());
		
		if(vo == null){
			logger.error("modify:管理员信息未持久化");
			throw new RuntimeException("管理员信息未持久化");
		}
		AnimeUser animeUser = this.animeUserMapper.selectByPrimaryKey(dto.getCustomerId());
		if(animeUser == null){
			logger.error("save:用户未持久化");
			throw new RuntimeException("用户未持久化");
		}
		AnimeRole animeRole = this.animeRoleMapper.selectByPrimaryKey(dto.getRoleId());
		if(animeRole == null){
			logger.error("save:角色未持久化");
			throw new RuntimeException("角色未持久化");
		}
		try {
			AnimeManager po = AnimeManager.class.newInstance();
			AutoMapper.mapping(dto,po);
			animeManagerMapper.updateByPrimaryKeySelective(po);
			return Boolean.TRUE;
		} catch (Exception e ) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public AnimeManagerVo getById(Integer id) {
		AnimeManagerVo vo = null;
		if (id == null) {
			return null;
		}
		AnimeManager po = animeManagerMapper.selectByPrimaryKey(id);
		if (po == null) {
			return null;
		}
		try {
			vo = AnimeManagerVo.class.newInstance();
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
		AnimeManager po = animeManagerMapper.selectByPrimaryKey(id);
		if (po == null) {
			logger.error("delete:数据未持久化");
			throw new RuntimeException("数据未持久化");
		}
		animeManagerMapper.deleteByPrimaryKey(id);
		return Boolean.TRUE;
	}

	@Override
	public PageResult<AnimeManagerVo> getListpager(Map<String, Object> params,
			Integer startRow, Integer pageSize) {
		startRow = startRow == null ? 1 : startRow;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(startRow, pageSize);

		List<AnimeManager> list = animeManagerMapper.getListpager(params);

		PageInfo<AnimeManager> pageInfo = new PageInfo<>(list);
		
		List<AnimeManagerVo> result = new ArrayList<AnimeManagerVo>();
		if (list != null && list.size() > 0) {
			for (AnimeManager po : list) {
				try {
					AnimeManagerVo vo = AnimeManagerVo.class.newInstance();
					AutoMapper.mapping(po, vo);
					result.add(vo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PageResult<AnimeManagerVo> pageResult = new PageResult<AnimeManagerVo>(); 
		pageResult.setPageNo(pageInfo.getPageNum());  
		pageResult.setPageSize(pageInfo.getPageSize());  
		pageResult.setDataList(result);  
		pageResult.setTotal(pageInfo.getTotal());  
		pageResult.setPages(pageInfo.getPages());  
		return pageResult;
	}

}
