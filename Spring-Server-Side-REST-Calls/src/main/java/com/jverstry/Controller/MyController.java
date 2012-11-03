
package com.jverstry.Controller;

import com.jverstry.Item.MilliTimeItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		return "index";
	}
	
    @RequestMapping(value = "/roundtrip")
    public String persistenceStatus(Model model) {
        
		MilliTimeItem retr = new MilliTimeItem();
		model.addAttribute("RoundTrip", retr);
		
		return "roundtrip";
		
    }	
	
}
