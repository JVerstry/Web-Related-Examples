
package com.firmflows.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * Configuration for a request handler for serving static resources.
	 * 
	 * This is to be used when the Spring MVC DispatcherServlet is
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
