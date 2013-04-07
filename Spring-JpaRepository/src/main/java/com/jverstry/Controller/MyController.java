package com.jverstry.Controller;

import com.jverstry.DAO.SomeItem;
import com.jverstry.Service.SomeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
    @Autowired
    private SomeItemService someItemService;

	@RequestMapping(value = "/")
	public ModelAndView index() {
        
        ModelAndView result = new ModelAndView("index");
        result.addObject("items", this.someItemService.getAll());
        
        return result;
        
    }
	
	@RequestMapping(value = "/delete/{id}")
	public String delete(
            @PathVariable(value="id")
            String id) {
        
        this.someItemService.delete(Long.parseLong(id));
        
        return "redirect:/";
        
    }
    
    @RequestMapping(value = "/create")
    @SuppressWarnings("AssignmentToMethodParameter")
	public String add() {
        
        SomeItem si = new SomeItem();
        si.setSomeText("Time is: " + System.currentTimeMillis());
        
        this.someItemService.saveAndFlush(si);
        
		return "redirect:/";
        
    }
        
}
