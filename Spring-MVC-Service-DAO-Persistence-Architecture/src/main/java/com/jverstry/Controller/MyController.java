
package com.jverstry.Controller;

import com.jverstry.Item.MilliTimeItem;
import com.jverstry.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
    @Autowired
    private MyService myService;

	@RequestMapping(value = "/")
	public String home(Model model) {
		
		return "index";
		
	}
	
    @RequestMapping(value = "/roundtrip")
    public String persistenceStatus(Model model) {
        
		MilliTimeItem retr = myService.createAndRetrieve();
		model.addAttribute("RoundTrip", retr);
		
		return "roundtrip";
		
    }	
	
}
