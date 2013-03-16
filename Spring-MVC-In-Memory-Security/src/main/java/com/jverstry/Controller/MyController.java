
package com.jverstry.Controller;

import com.jverstry.UserDetailsManager.PracticalUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
    @Autowired
    private PracticalUserDetailsManager pudm;

	@RequestMapping(value = "/")
	public ModelAndView index() {
        
        ModelAndView result = new ModelAndView("index");
        
        result.addObject("users", this.pudm.getUsers());
        result.addObject("errorMsg", "");
        
        return result;
        
    }
	
	@RequestMapping(value = "/delete/{name}")
	public ModelAndView delete(
            @PathVariable(value="name")
            String id) {
        
        this.pudm.deleteUser(id);
        
        return index();
        
    }
    
    @RequestMapping(value = "/add")
    @SuppressWarnings("AssignmentToMethodParameter")
	public ModelAndView add(
            @RequestParam(value="name")
            String name,
            @RequestParam(value="password")
            String password
            ) {
        
        name = StringUtils.replace(name, " ", "");
        password = StringUtils.replace(password, " ", "");
        
        String errorMsg = "";
        
        if ( name.length() == 0 ) {
            errorMsg += "Name is empty ";
        }
        
        if ( password.length() == 0 ) {
            errorMsg += "Password is empty ";
        }
        
        ModelAndView result = new ModelAndView("index");
        
        result.addObject("errorMsg", errorMsg);
        result.addObject("users", this.pudm.getUsers());
        
		return result;
        
	}
    
}
