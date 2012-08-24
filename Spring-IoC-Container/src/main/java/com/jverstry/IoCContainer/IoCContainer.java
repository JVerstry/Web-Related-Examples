
package com.jverstry.IoCContainer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCContainer {
	
	public static final ApplicationContext ac
		= new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static void main(String[] args) {
		
	}
	
}
