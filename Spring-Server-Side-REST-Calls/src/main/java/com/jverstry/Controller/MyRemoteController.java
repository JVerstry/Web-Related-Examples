
package com.jverstry.Controller;

import com.jverstry.DataModel.MyRemoteData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/MyRemoteData")
public class MyRemoteController {

	@RequestMapping(value="/{time}", method = RequestMethod.GET)
	public @ResponseBody MyRemoteData getMyRemoteData(
			@PathVariable long time) {
		
		return new MyRemoteData(
			"My remote data called at: " + time + " !!!");
	}

}