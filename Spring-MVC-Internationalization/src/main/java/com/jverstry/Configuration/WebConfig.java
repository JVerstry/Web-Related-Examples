
package com.jverstry.Configuration;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.jverstry")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		
		InternalResourceViewResolver resolver
			= new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/pages/");
		resolver.setSuffix(".jsp");

		return resolver;
		
	}
	
	@Bean
	public MessageSource messageSource() {
	
		ResourceBundleMessageSource result
			= new ResourceBundleMessageSource();
		
		String[] basenames = {
		    "i18n.setA.setA",
		    "i18n.setB.setB"
		};
		
		result.setBasenames(basenames);
		
		return result;
		
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		
		LocaleChangeInterceptor result = new LocaleChangeInterceptor();
		result.setParamName("lang");
		
		return result;
		
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		
		SessionLocaleResolver result = new SessionLocaleResolver();
		result.setDefaultLocale(Locale.ENGLISH);
		
		return result;
		
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}	
	
}
