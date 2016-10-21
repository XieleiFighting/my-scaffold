package com.hades.scaffold.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * User: XieLei
 * <p>
 * Date: 2016年10月19日 下午4:08:17
 * <p>
 * Version: 1.0
 */
@Controller
public class LoginFormController {

	@RequestMapping(value = { "/", "index" })
	public String index() {
		return "index";
	}

	@RequestMapping(value = { "/{login:login;?.*}" }, method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request, ModelMap model) {

		return "front/login";
	}

	@RequestMapping(value = { "/{login:login;?.*}" }, method = RequestMethod.POST)
	public String login(HttpServletRequest request, ModelMap model) {
		String exception = (String) request.getAttribute("shiroLoginFailure");
		System.out.println(exception);
		String msg = "";
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				System.out.println("UnknownAccountException -->帐号不存在：");
				msg = "UnknownAccountException -->帐号不存在：";
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				System.out.println("IncorrectCredentialsException -- > 密码不正确：");
				msg = "IncorrectCredentialsException -- > 密码不正确：";
			} else if ("kaptchaValidateFailed".equals(exception)) {
				System.out.println("kaptchaValidateFailed -- > 验证码错误");
				msg = "kaptchaValidateFailed -- > 验证码错误";
			} else {
				msg = "else >> " + exception;
				System.out.println("else -- >" + exception);
			}
		}
		return "index";
	}
}
