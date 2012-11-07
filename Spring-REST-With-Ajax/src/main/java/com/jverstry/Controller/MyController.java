
package com.jverstry.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MyController {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		return "index";
	}
	
}
