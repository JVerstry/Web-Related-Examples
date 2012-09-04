
package com.jverstry.Configuration;

import com.jverstry.Service.MyService;
import com.jverstry.Service.MyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
	"com.jverstry.Controller",
	"com.jverstry.DAO",
	"com.jverstry.Item",
	"com.jverstry.Service"
})
public class TestConfig {
	
	@Bean
	public MyService getMyService() {
		return new MyServiceImpl();
	}
	
}
