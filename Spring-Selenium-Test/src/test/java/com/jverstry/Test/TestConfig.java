
package com.jverstry.Test;

import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    
	@Bean
	public URI getSiteBase() throws URISyntaxException {
        return new URI("http://localhost:10001/spring-selenium-test-1.0.0");
    }    
    
	@Bean(destroyMethod="quit")
	public FirefoxDriver getDrv() {
        return new FirefoxDriver();
    }
    
}
