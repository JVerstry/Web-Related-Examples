
package com.jverstry.Configuration;

import com.jverstry.Service.MyService;
import com.jverstry.Service.MyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {
	"com.jverstry.Controller",
	"com.jverstry.DAO",
	"com.jverstry.Item",
	"com.jverstry.Service"
})
public class TestConfig {
	
	@Bean
	public ViewResolver getViewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/pages/");
		resolver.setSuffix(".jsp");

		return resolver;
		
	}
	
	@Bean
	public MyService getMyService() {
		return new MyServiceImpl();
	}
	
}
