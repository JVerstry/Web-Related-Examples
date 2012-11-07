
package com.jverstry.Controller;

import com.jverstry.DataModel.MyData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/MyData")
public class MyRESTController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody MyData getMyData(Model model) {
		return new MyData(
		    System.currentTimeMillis(), "REST GET Call !!!");
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody MyData putMyData(Model model) {
		return new MyData(
			System.currentTimeMillis(), "REST PUT Call !!!");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody MyData postMyData(Model model) {
		return new MyData(
			System.currentTimeMillis(), "REST POST Call !!!");
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody MyData deleteMyData(Model model) {
		return new MyData(
			System.currentTimeMillis(), "REST DELETE Call !!!");
	}

}
