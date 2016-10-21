package com.hades.scaffold.server.conf;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hades.scaffold.shiro.UserRealm;

@Configuration
@ConfigurationProperties(prefix = "shiro")
public class ShiroConfig {
	
	private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
	@Value("${shiro.loginUrl}")
	private String loginUrl;
	@Value("${shiro.successUrl}")
	private String successUrl;
	@Value("${shiro.unauthorizedUrl}")
	private String unauthorizedUrl;

	@Bean(name = "cacheManager")
	public EhCacheManager cacheManager() {
		EhCacheManager em = new EhCacheManager();
		em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return em;
	}
	
	@Bean(name = "userRealm")
	public UserRealm userRealm() {
		return new UserRealm();
	}
	
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
		dwsm.setRealm(userRealm());
//		dwsm.setSessionManager(sessionManager);
		dwsm.setCacheManager(cacheManager());
		dwsm.setRememberMeManager(rememberMeManager());
		return dwsm;
	}
	
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl(successUrl);
		shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/jcaptcha*", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return shiroFilterFactoryBean;
	}
	
	@Bean(name = "rememberMeManager")
	public CookieRememberMeManager rememberMeManager() {
		CookieRememberMeManager crm = new CookieRememberMeManager();
		crm.setCipherKey(org.apache.shiro.codec.Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
		crm.setCookie(rememberMeCookie());
		return crm;
	}
	
	@Bean(name = "rememberMeCookie")
	public SimpleCookie rememberMeCookie() {
		SimpleCookie cookie = new SimpleCookie("rememberMe");
		cookie.setMaxAge(2592000);
		cookie.setHttpOnly(true);
		return cookie;
	}
	
	@Bean(name = "sessionIdCookie")
	public SimpleCookie sessionIdCookie() {
		SimpleCookie cookie = new SimpleCookie("sid");
		cookie.setMaxAge(-1);
		cookie.setHttpOnly(true);
		return cookie;
	}
	
}
