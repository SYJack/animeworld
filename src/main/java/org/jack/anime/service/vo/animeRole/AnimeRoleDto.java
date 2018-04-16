package org.jack.anime.service.vo.animeRole;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotEmpty;
import org.jack.anime.entity.BaseEntity;
import org.jack.anime.service.vo.rolePerm.RolePermDto;

public class AnimeRoleDto extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8386887952752625656L;
	
	public interface Save {
	}

	public interface Modify {
	}
	
	@NotNull(message ="id不能为空",groups = {Modify.class})
	@Null(message= "id必须为空",groups = {Save.class})
	private Integer id;
	
	@NotEmpty(message = "角色名称不能为空", groups = { Save.class,Modify.class})
    private String name;

    private String description;
    
    private List<RolePermDto> list;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RolePermDto> getList() {
		return list;
	}

	public void setList(List<RolePermDto> list) {
		this.list = list;
	}
	
	

}
