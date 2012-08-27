
package com.jverstry.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Replaces the typical application-context.xml file.
 */
@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * A view resolver takes the value returned by methods handling
	 * user requests and typically converts it into a file/resource location.
	 */
	@Bean
	public ViewResolver getViewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		// This passes the view (JSP) for taglibs processin (JSLT)
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/pages/");
		resolver.setSuffix(".jsp");

		return resolver;
		
	}
	
	/**
	 * Configuration for a request handler for serving static resources.
	 * 
	 * This is indended to be used when the Spring MVC DispatcherServlet is
	 * mapped to "/" thus overriding the Servlet container's default handling
	 * of static resources.
	 * 
	 * Since this handler is configured at the lowest precedence, effectively
	 * it allows all other handler mappings to handle the request, and if none
	 * of them do, this handler can forward it to the "default" Servlet. 
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

		// Good practice
		super.configureDefaultServletHandling(configurer);
		
		//  Enables forwarding to the "default" Servlet.
		configurer.enable();
		
	}
	
}
