
package com.jverstry.Service.User;

import com.jverstry.Data.PracticalUserDetails.PracticalUserDetails;
import com.jverstry.Data.PracticalUserDetails.PracticalUserDetailsDAO;
import java.util.Set;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PracticalUserDetailsService extends UserDetailsService {
    
    Set<PracticalUserDetailsDAO.UserIdentifiers> getUsers();
    
    void deleteUser(long id);
    void upsertUser(PracticalUserDetails user);
    
    PracticalUserDetails getUser(long id);
    PracticalUserDetails getUser(String username);
    
    

}
