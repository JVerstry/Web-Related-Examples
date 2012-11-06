
package com.jverstry.Controller;

import com.jverstry.ErrorHandling.Customized4ExceptionHandler;
import com.jverstry.ErrorHandling.CustomizedException1;
import com.jverstry.ErrorHandling.CustomizedException2;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TriggeringErrorsController {
	
	@RequestMapping(value = "/throwCustomizedException1")
    public ModelAndView throwCustomizedException1(
		HttpServletRequest request,HttpServletResponse response)
			throws CustomizedException1 {
		
		throw new CustomizedException1(
			"Houston, we have a problem!");
	}	

	@RequestMapping(value = "/throwCustomizedException2")
    public ModelAndView throwCustomizedException2(
		HttpServletRequest request,HttpServletResponse response)
			throws CustomizedException2 {
		
		throw new CustomizedException2(
			"Something happened on the way to heaven!");
	}
	
	@ExceptionHandler(Customized4ExceptionHandler.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST) 
	@ResponseBody
	public String handleCustomized4Exception(
		Customized4ExceptionHandler ex) {
		
        return ex.getSpecialMsg();
		
	}

	@RequestMapping(value = "/throwCustomized4ExceptionHandler")
    public ModelAndView throwCustomized4ExceptionHandler(
		HttpServletRequest request,HttpServletResponse response)
			throws Customized4ExceptionHandler {
		
		throw new Customized4ExceptionHandler(
			"S.O.S !!!!");
	}	
	
}
