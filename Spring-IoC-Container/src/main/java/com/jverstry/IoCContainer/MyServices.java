
package com.jverstry.IoCContainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyServices {
	
    private MyService myService;

    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }
	
	public MyService getMyService() {
		return this.myService;
	}
	
}
