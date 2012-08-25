
package com.jverstry.IoCContainer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {
	
	private MyService myService = new MyService() {

		@Override
		public long getData() {
			return System.currentTimeMillis();
		}
		
	};
	
	@Bean
	public MyService getMyService() {
		return myService;
	}
	
}
