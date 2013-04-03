package com.jverstry.Controller;

import com.jverstry.Data.PracticalUserDetails.PracticalUserDetailsImpl;
import com.jverstry.Service.User.PracticalUserDetailsServiceInMemory;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInitialization {

    @Autowired
    private PracticalUserDetailsServiceInMemory pudsim;    
    
    @PostConstruct
    public void init() {
        
        this.pudsim.upsertUser(new PracticalUserDetailsImpl("admin","admin"));
        this.pudsim.upsertUser(new PracticalUserDetailsImpl("marc","1234"));
        
    }
    
}
