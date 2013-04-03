package com.jverstry.Controller;

import com.jverstry.DAO.PracticalUserDetailsImpl;
import com.jverstry.UserDetailsService.PracticalUserDetailsServiceInMemory;
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
    private PracticalUserDetailsServiceInMemory pudm;

	@RequestMapping(value = "/")
	public ModelAndView index() {
        
        ModelAndView result = new ModelAndView("index");

        result.addObject("users", this.pudm.getUsers());
        
        return result;
        
    }
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(
            @PathVariable(value="id")
            String id) {
        
        this.pudm.deleteUser(Long.parseLong(id));
        
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
            this.pudm.upsertUser(new PracticalUserDetailsImpl(name, password));
        }
    
        ModelAndView result = new ModelAndView("create");
        
        result.addObject("errorMsg", errorMsg);
        result.addObject("username", name);
        
		return result;
        
    }
        
}
