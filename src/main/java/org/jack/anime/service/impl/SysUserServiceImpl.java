package org.jack.anime.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.beanutils.BeanUtils;
import org.jack.anime.common.dataMapping.AutoMapper;
import org.jack.anime.dao.AnimeUserMapper;
import org.jack.anime.entity.AnimeUser;
import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.SysUserService;
import org.jack.anime.service.vo.animeUser.AnimeUserDto;
import org.jack.anime.service.vo.animeUser.AnimeUserVo;
import org.jack.anime.utils.constant.Constants;
import org.jack.anime.utils.tool.Digests;
import org.jack.anime.utils.tool.Encodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service("sysUserServiceImpl")
public class SysUserServiceImpl implements SysUserService {

	private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Resource(name = "animeUserMapper")
	AnimeUserMapper animeUserMapper;
	
	@Override
	public Integer countAnime() {
		Integer result = (Integer) animeUserMapper.totalItem();
		return result;
	}

	@Override
	public Integer save(AnimeUserDto dto) {
		Set<ConstraintViolation<AnimeUserDto>> set = this.validator.validate(dto, AnimeUserDto.Save.class);
		for (ConstraintViolation<AnimeUserDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		Map<String, Object> map =new HashMap<String, Object>();
		Integer result = null;
		if(dto == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		if(dto.getLoginname()!=null){
			map.put("loginName", dto.getLoginname());
			if(animeUserMapper.selectCountByOneParam(map)!=null){
				logger.error("save:登录名称已经存在");
				throw new RuntimeException("登录名称已经存在");
			}
			map.clear();
		}
		if(dto.getMobile()!=null){
			map.put("mobile", dto.getMobile());
			if(animeUserMapper.selectCountByOneParam(map)!=null){
				logger.error("save:手机已经被绑定");
				throw new RuntimeException("手机已经被绑定");
			}
			map.clear();
		}
		if(dto.getEmail()!=null){
			map.put("email", dto.getEmail());
			if(animeUserMapper.selectCountByOneParam(map)!=null){
				logger.error("save:该邮箱已被使用");
				throw new RuntimeException("该邮箱已被使用");
			}
			map.clear();
		}
		try {
			byte[] salt = Digests.generateSalt(Constants.SALT_SIZE);
			dto.setSalt(Encodes.encodeHex(salt));
			byte[] hashPassword = Digests.sha1(dto.getPasswd().getBytes(), salt, Constants.HASH_INTERATIONS);
			dto.setPasswd(Encodes.encodeHex(hashPassword));
			
			AnimeUser po = AnimeUser.class.newInstance();
			AutoMapper.mapping(dto,po);
			result = animeUserMapper.insertSelective(po);
		} catch (Exception e ) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public Boolean modify(AnimeUserDto dto) {
		Set<ConstraintViolation<AnimeUserDto>> set = this.validator.validate(dto, AnimeUserDto.Modify.class);
		for (ConstraintViolation<AnimeUserDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		if(dto == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		AnimeUserVo vo = this.getById(dto.getId());
		
		if(vo == null){
			logger.error("modify:系统用户信息未持久化");
			throw new RuntimeException("系统用户信息未持久化");
		}
		try {
			AnimeUser animeUser = AnimeUser.class.newInstance();
			AutoMapper.mapping(dto,animeUser);
			animeUserMapper.updateByPrimaryKeySelective(animeUser);
			return Boolean.TRUE;
		} catch (Exception e ) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public AnimeUserVo getById(Integer id) {
		AnimeUserVo vo = null;
		if (id == null) {
			return null;
		}
		AnimeUser po = animeUserMapper.selectByPrimaryKey(id);
		if (po == null) {
			return null;
		}
		try {
			vo = AnimeUserVo.class.newInstance();
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
		AnimeUser po = animeUserMapper.selectByPrimaryKey(id);
		if (po == null) {
			logger.error("delete:数据未持久化");
			throw new RuntimeException("数据未持久化");
		}
		animeUserMapper.deleteByPrimaryKey(id);
		return Boolean.TRUE;
	}

	@Override
	public PageResult<AnimeUserVo> getListpager(Map<String, Object> params, Integer startRow, Integer pageSize) {
		startRow = startRow == null ? 1 : startRow;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(startRow, pageSize);

		List<AnimeUser> list = animeUserMapper.getListpager(params);

		PageInfo<AnimeUser> pageInfo = new PageInfo<>(list);
		
		List<AnimeUserVo> result = new ArrayList<AnimeUserVo>();
		if (list != null && list.size() > 0) {
			for (AnimeUser po : list) {
				try {
					AnimeUserVo vo = AnimeUserVo.class.newInstance();
					AutoMapper.mapping(po, vo);
					result.add(vo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PageResult<AnimeUserVo> pageResult = new PageResult<AnimeUserVo>(); 
		pageResult.setPageNo(pageInfo.getPageNum());  
		pageResult.setPageSize(pageInfo.getPageSize());  
		pageResult.setDataList(result);  
		pageResult.setTotal(pageInfo.getTotal());  
		pageResult.setPages(pageInfo.getPages());  
		return pageResult;
	}

}
