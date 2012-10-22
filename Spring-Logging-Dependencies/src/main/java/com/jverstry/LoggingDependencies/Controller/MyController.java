
package com.jverstry.LoggingDependencies.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
    private static final Logger LOG
		= LoggerFactory.getLogger(MyController.class);
	
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		
		String s = "Logging at: " + System.currentTimeMillis();
	    LOG.info(s);
		
		model.addAttribute("LogMsg", s);
		
		return "index";
		
	}
	
}
