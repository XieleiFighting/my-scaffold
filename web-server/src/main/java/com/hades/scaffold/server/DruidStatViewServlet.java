package com.hades.scaffold.server;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",
	initParams = {
			@WebInitParam(name = "allow", value = "127.0.0.1")
	})
public class DruidStatViewServlet extends StatViewServlet {

}
