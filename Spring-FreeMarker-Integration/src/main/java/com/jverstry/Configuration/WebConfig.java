
package com.jverstry.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.jverstry")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setCache(false);
//		resolver.setPrefix("");
		resolver.setSuffix(".ftl");

		return resolver;
		
	}
	
	@Bean
	public FreeMarkerConfigurer getFreemarkerConfig() {
		
		FreeMarkerConfigurer result = new FreeMarkerConfigurer();
		
		result.setTemplateLoaderPath("WEB-INF/pages/");
		
		return result;
		
	}	
	
}
