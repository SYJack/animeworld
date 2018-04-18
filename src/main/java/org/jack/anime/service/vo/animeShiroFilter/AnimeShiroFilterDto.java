package org.jack.anime.service.vo.animeShiroFilter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotEmpty;
import org.jack.anime.entity.BaseEntity;

public class AnimeShiroFilterDto extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2680637565738140939L;
	
	public interface Save {
	}

	public interface Modify {
	}
	
	@NotNull(message ="id不能为空",groups = {Modify.class})
	@Null(message= "id必须为空",groups = {Save.class})
    private Integer id;

	
	@NotEmpty(message = "资源字段名称不能为空", groups = { Save.class,Modify.class})
    private String name;

    @NotEmpty(message = "权限不能为空", groups = { Save.class,Modify.class})
    private String perms;

    private Integer sortOrder;

    private Long createTimestamp;

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

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
    
    

}
