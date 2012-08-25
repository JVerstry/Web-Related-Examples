
package com.jverstry.IoCContainer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCContainerExample {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.jverstry");
		ctx.refresh();		
		
		MyServices mcs = ctx.getBean(MyServices.class);
		System.out.println("Data: " + mcs.getMyService().getData());
		
	}
	
}
