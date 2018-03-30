package org.jack.anime.service.vo.animeUser;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.jack.anime.entity.BaseEntity;

public class AnimeUserDto extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6421650394739474801L;

	public interface Save {
	}

	public interface Modify {
	}
	
	@NotNull(message ="id不能为空",groups = {Modify.class})
	@Null(message= "id必须为空",groups = {Save.class})
	private Integer id;

	@Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0-9])|(147))\\d{8}$",message="手机号格式不正确")
    private String mobile;

    private String portraitUrl;

    @NotEmpty(message = "登录名不能为空", groups = { Save.class, Modify.class})
    private String loginname;

    private String nickname;
    
    @NotNull(message ="状态不能为空",groups = {Modify.class ,Save.class})
    private Short status;

    private Short gender;

    private Long createTimestamp;

    @Email(regexp="(?:\\w[-._\\w]*\\w@\\w[-._\\w]*\\w\\.\\w{2,3}$)",message="{email.format.error}")
    private String email;
    
    @NotEmpty(message = "密码不能为空", groups = { Save.class})
    private String passwd;
    
    private String salt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPortraitUrl() {
		return portraitUrl;
	}

	public void setPortraitUrl(String portraitUrl) {
		this.portraitUrl = portraitUrl;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Short getGender() {
		return gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	public Long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
    
	
}
