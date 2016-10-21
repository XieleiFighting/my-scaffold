package com.hades.scaffold.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hades.scaffold.entity.User;
import com.hades.scaffold.service.UserService;

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	/**
	 * 权限控制,当访问到页面的时候，使用了相应的注解或者shiro标签才会执行此方法否则不会执行
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		User user = userService.findByUsername(username);
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// TODO 
		return authorizationInfo;
	}

	/**
	 * 进行身份认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername().trim();
		String password = "";
		if (upToken.getPassword() != null) {
            password = new String(upToken.getPassword());
        }
		User user = null;
		try {
			user = userService.login(username, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password.toCharArray(), getName());
		return info;
	}

}
