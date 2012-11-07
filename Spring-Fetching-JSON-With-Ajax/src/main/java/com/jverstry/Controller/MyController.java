
package com.jverstry.Controller;

import com.jverstry.Item.MilliTimeItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/getJSON", method = RequestMethod.GET)
    public @ResponseBody MilliTimeItem getJSON() {
		return new MilliTimeItem(System.currentTimeMillis());
    }
	
}
