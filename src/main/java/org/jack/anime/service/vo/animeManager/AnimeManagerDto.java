package org.jack.anime.service.vo.animeManager;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.jack.anime.entity.BaseEntity;

public class AnimeManagerDto extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7590165364501067599L;

	public interface Save {
	}

	public interface Modify {
	}
	
	@NotNull(message ="id不能为空",groups = {Modify.class})
	@Null(message= "id必须为空",groups = {Save.class})
	private Integer id;

	@NotNull(message ="角色不能为空",groups = {Modify.class,Save.class})
    private Integer roleId;

	@NotNull(message ="用户不能为空",groups = {Modify.class,Save.class})
    private Integer customerId;

	@NotNull(message ="状态不能为空",groups = {Modify.class,Save.class})
    private Short status;

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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}
