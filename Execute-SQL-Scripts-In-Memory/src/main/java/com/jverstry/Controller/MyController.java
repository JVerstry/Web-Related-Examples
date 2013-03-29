
package com.jverstry.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
    @Autowired
    EmbeddedDatabase hsqlInMemory;
    
	@RequestMapping(value = "/")
	public ModelAndView home() {
        
        ModelAndView result = new ModelAndView("index");
        
        ArrayList<String> tables = new ArrayList<String>();
        
        JdbcTemplate tplate = new JdbcTemplate(hsqlInMemory);
        
        SqlRowSet retr = tplate.queryForRowSet(
            "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES");
        
        while (retr.next()) {
            tables.add(retr.getString(1));
        }
        
        result.addObject("tables", tables);
		
		return result;
		
	}
	
}