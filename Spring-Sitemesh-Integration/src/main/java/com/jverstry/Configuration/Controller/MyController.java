
package com.jverstry.Configuration.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping(value = "/")
	public String home() {
		return "Home";
	}
	
	@RequestMapping(value = "/AnotherPage")
	public String anotherPage() {
		return "AnotherPage";
	}
	
}
