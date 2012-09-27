
package com.jverstry.LoginLogout.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		
		model.addAttribute("CurrPrincipal",
			SecurityContextHolder.getContext()
				.getAuthentication().getName());
		
		return "index";
		
	}
	
}
