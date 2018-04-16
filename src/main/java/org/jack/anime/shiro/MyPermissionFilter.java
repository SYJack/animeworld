package org.jack.anime.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPermissionFilter extends AuthorizationFilter {

	private static final Logger logger = LoggerFactory.getLogger(MyPermissionFilter.class);
	
	@Override
	protected boolean isAccessAllowed(ServletRequest req, ServletResponse res,
			Object obj) throws Exception {
		return false;
	}

}
