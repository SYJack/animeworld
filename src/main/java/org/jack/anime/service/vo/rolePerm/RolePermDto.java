package org.jack.anime.service.vo.rolePerm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.jack.anime.entity.BaseEntity;
import org.jack.anime.service.vo.animeRole.AnimeRoleDto.Modify;

public class RolePermDto extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8023795798527586170L;
	
	public interface Save {
	}

	public interface Modify {
	}
	
	@NotNull(message ="id不能为空",groups = {Modify.class})
	@Null(message= "id必须为空",groups = {Save.class})
	private Integer id;

	@NotNull(message ="roleId不能为空",groups = {Modify.class,Save.class})
    private Integer roleId;

	@NotNull(message ="permissionId不能为空",groups = {Modify.class,Save.class})
    private Integer permissionId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
    
    

}
