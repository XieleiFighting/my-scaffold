package com.hades.scaffold;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Bootstrap {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Bootstrap.class, args);
		if (context instanceof EmbeddedWebApplicationContext) {
			int port = ((EmbeddedWebApplicationContext) context).getEmbeddedServletContainer().getPort();
			String contextPath = context.getApplicationName();
			String url = String.format(Locale.SIMPLIFIED_CHINESE, "http://localhost:%d%s", port, contextPath);
			
			// 提示项目用到的相关配置文件
			log.info(" =========== ${user.dir}={}  ===========  ", System.getProperty("user.dir"));
			log.info(" =========== ${java.io.tmpdir}={} ===========  ", System.getProperty("java.io.tmpdir"));
			
			String dashes = "------------------------------------------------------------------------";
			log.info("Access URLs:\n{}\n\tLocal: \t\t{}\n{}", dashes, url, dashes);
		}
	}
}
