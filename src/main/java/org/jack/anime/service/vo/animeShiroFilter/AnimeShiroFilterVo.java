/**
 * 
 */
package org.jack.anime.service.vo.animeShiroFilter;

import org.jack.anime.entity.BaseEntity;

/**
 * @author jack
 *
 */
public class AnimeShiroFilterVo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8905976597328550246L;
	
    private Integer id;

    private String name;

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
