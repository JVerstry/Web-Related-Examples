
package com.jverstry.Controller;

import com.jverstry.DataModel.MyData;
import com.jverstry.DataModel.MyRemoteData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(value = "/MyData")
public class MyRESTController {

	@RequestMapping(value="/{time}", method = RequestMethod.GET)
	public @ResponseBody MyData getMyData(
			@PathVariable long time) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String remote = "http://localhost:8585/spring-server-side-rest-call/"
			+ "MyRemoteData/" + System.currentTimeMillis();
		
		MyRemoteData mrd = restTemplate.getForObject(
			remote, MyRemoteData.class);
		
		return new MyData(System.currentTimeMillis(), mrd.getData());
		
	}

}