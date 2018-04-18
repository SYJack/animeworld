package org.jack.anime.shiro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.jack.anime.dao.AnimeManagerMapper;
import org.jack.anime.dao.AnimePermissionMapper;
import org.jack.anime.dao.AnimeRoleMapper;
import org.jack.anime.dao.AnimeUserMapper;
import org.jack.anime.entity.AnimeManager;
import org.jack.anime.entity.AnimeRole;
import org.jack.anime.entity.AnimeUser;
import org.jack.anime.service.impl.AnimeTimetableServiceImpl;
import org.jack.anime.utils.tool.Encodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "authRealm")
public class AuthRealm extends AuthorizingRealm{

	@Resource(name = "animeUserMapper")
	AnimeUserMapper animeUserMapper;
	
	@Resource(name = "animeManagerMapper")
	AnimeManagerMapper animeManagerMapper;
	
	@Resource(name = "animeRoleMapper")
	AnimeRoleMapper animeRoleMapper;
	
	@Resource(name = "animePermissionMapper")
	AnimePermissionMapper animePermissionMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(AnimeTimetableServiceImpl.class);
	/**  
     * 认证  
     */  
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken  token = (UsernamePasswordToken) authenticationToken;
		String loginName = (String)token.getPrincipal();
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("loginName", loginName);
		AnimeUser user = animeUserMapper.selectCountByOneParam(map);
		if(user == null) {
			logger.error("login:没有找到相关账号");
            throw new UnknownAccountException("没有找到相关账号");//没找到帐号
        }
        if(user.getStatus() == Short.valueOf("0")) {
        	logger.error("login:账号被锁定");
            throw new LockedAccountException("账号被锁定"); //帐号锁定
        }
        byte[] salt = Encodes.decodeHex(user.getSalt());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                new ShiroUser(user.getId(),user.getLoginname(),user.getNickname(), user.getPortraitUrl()),
                user.getPasswd(), //密码
                ByteSource.Util.bytes(salt),
                getName()  //realm name
        );
		return authenticationInfo;
	}
	
	
	 /**  
     * 授权,只有成功通过doGetAuthenticationInfo方法的认证后才会执行。
     */  
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		ShiroUser shiroUser = (ShiroUser)principalCollection.getPrimaryPrincipal();
		AnimeManager animeManager = animeManagerMapper.selectByCId(shiroUser.getId());
		AnimeRole animeRole = animeRoleMapper.selectByPrimaryKey(animeManager.getRoleId());
		SimpleAuthorizationInfo info = null;
		if(!StringUtils.isEmpty(animeRole.getName())){
			info = new SimpleAuthorizationInfo();
			//获得授权角色
			info.addRole(animeRole.getName());
			//获得授权权限
			info.addStringPermissions(animePermissionMapper.getPermissions(shiroUser.getId()));
		}
		return info;
	}
	
	//清除缓存
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
	
	/**
     * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
     */
	public static class ShiroUser implements Serializable {
		
		private static final long serialVersionUID = 8341487335200480515L;
		public Integer id;
        public String loginName;
        public String nickName;
        public String icon;
        
		public ShiroUser(Integer id, String loginName, String nickName, String icon) {
			this.id = id;
			this.loginName = loginName;
			this.nickName = nickName;
			this.icon = icon;
		}

		public Integer getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getNickName() {
			return nickName;
		}

		public String getIcon() {
			return icon;
		}

		/**
         * 重载hashCode,只计算loginName;
         */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((loginName == null) ? 0 : loginName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ShiroUser other = (ShiroUser) obj;
			if (loginName == null) {
				if (other.loginName != null)
					return false;
			} else if (!loginName.equals(other.loginName))
				return false;
			return true;
		}
        
	}

}
