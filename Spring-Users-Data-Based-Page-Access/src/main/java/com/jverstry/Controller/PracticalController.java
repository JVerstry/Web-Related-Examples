package com.jverstry.Controller;

import com.jverstry.Data.PracticalUserDetails.PracticalUserDetails;
import com.jverstry.Data.PracticalUserDetails.PracticalUserDetailsImpl;
import com.jverstry.Service.User.PracticalAuthenticationProvider;
import com.jverstry.Service.User.PracticalUserDetailsServiceInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PracticalController {
	
    @Autowired
    private PracticalUserDetailsServiceInMemory pudsim;
    
    @Autowired
    private PracticalAuthenticationProvider pap;

	@RequestMapping(value = "/")
	public ModelAndView slash() {
        
        return slash();
        
    }
    
	@RequestMapping(value = "/index.jsp")
	public ModelAndView index() {
        
        ModelAndView result = new ModelAndView("index");

        // Anyone logged in?
        PracticalUserDetails user = PracticalAuthenticationProvider.getLoggedInUser();
        
        if ( user == null ) {
            result.addObject("loggedIn", "No one is logged in");
        } else {
            result.addObject("loggedIn", user.getUsername() + " is logged in");
        }
        
        result.addObject("users", this.pudsim.getUsers());
        
        return result;
        
    }
    
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(
            @PathVariable(value="id")
            String id) {
        
        this.pudsim.deleteUser(Long.parseLong(id));
        
        return "redirect:/";
        
    }
    
    @RequestMapping(value = "/create")
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
        
        if ( errorMsg.isEmpty() ) {
            this.pudsim.upsertUser(new PracticalUserDetailsImpl(name, password));
        }
    
        ModelAndView result = new ModelAndView("create");
        
        result.addObject("errorMsg", errorMsg);
        result.addObject("username", name);
        
		return result;
        
    }
    
	@RequestMapping(value = "/accessDenied")
	public ModelAndView accessDenied() {
        
        ModelAndView result = new ModelAndView("accessDenied");
        
        return result;
        
    }
    
	@RequestMapping(value = "/invalidSession")
	public ModelAndView invalidSession() {
        
        ModelAndView result = new ModelAndView("invalidSession");
        
        result.addObject("noUser",
            (SecurityContextHolder.getContext().getAuthentication()==null));
        
        return result;
        
    }
        
}
