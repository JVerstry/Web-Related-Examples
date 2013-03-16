
package com.jverstry.Controller;

import com.jverstry.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
    private MyService myService;

    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }
	
	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}
	
    @RequestMapping(value = "/getTime")
    public String helloWorld(Model model) {
        
		model.addAttribute("TimeIs", myService.getCurrentTimeInMilliseconds());
		
		return "getTime";
		
    }	
	
}
