
package com.jverstry.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServicesConfiguration {
	
	private MyService myService = new MyServiceImpl();
	
	@Bean
	public MyService getMyService() {
		return myService;
	}	
	
}
