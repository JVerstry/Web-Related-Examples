
package com.jverstry.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/retrieveUrlGetParameters")
	public ModelAndView retrUrlGetParameters(
        @RequestParam(value="firstName")
        String firstName,
        @RequestParam(value="lastName")
        String lastName
        ) {
        
        ModelAndView result = new ModelAndView("retrieveUrlGetParameters");
        
        System.out.println(firstName + " " + lastName);
        
        result.addObject("retrFirstName", firstName);
        result.addObject("retrLastName", lastName);
        
		return result;
        
	}
    
}
