
package com.jverstry.Controller;

import com.jverstry.DataModel.MyData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/MyData")
public class MyRESTController {

	@RequestMapping(value="/{time}", method = RequestMethod.GET)
	public @ResponseBody MyData getMyData(
			@PathVariable long time) {
		
		return new MyData(time, "REST GET Call !!!");
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody MyData putMyData(
			@RequestBody MyData md) {
		
		return md;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody MyData postMyData() {
		return new MyData(
			System.currentTimeMillis(), "REST POST Call !!!");
	}

	@RequestMapping(value="/{time}", method = RequestMethod.DELETE)
	public @ResponseBody MyData deleteMyData(
			@PathVariable long time) {
		
		return new MyData(time, "REST DELETE Call !!!");
	}

}