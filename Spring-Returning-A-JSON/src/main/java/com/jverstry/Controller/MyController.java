
package com.jverstry.Controller;

import com.jverstry.Data.SomeData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/getJSON/{name}", method = RequestMethod.GET)
    public @ResponseBody SomeData getJSON(@PathVariable String name) {
        
		SomeData result = new SomeData(name, System.currentTimeMillis());
		
		return result;
		
    }	
	
}
