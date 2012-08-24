
package com.jverstry.SpringStandalone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStandalone {
	
	public static final ApplicationContext ac
		= new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static void main(String[] args) {
		
	}
	
}
