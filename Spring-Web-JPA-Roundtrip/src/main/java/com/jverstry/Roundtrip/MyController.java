
package com.jverstry.Roundtrip;

import com.jverstry.Roundtrip.Item;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@Autowired
	private MyRepository rep;	
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		
		return "index";
		
	}
	
    @RequestMapping(value = "/roundtrip")
    public String Roundtrip(Model model) {
        
		model.addAttribute("Messages", rep.performRoundtrip());
		
		return "roundtrip";
		
    }
	
}
