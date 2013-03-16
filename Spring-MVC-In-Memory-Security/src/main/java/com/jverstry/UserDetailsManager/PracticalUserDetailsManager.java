
package com.jverstry.UserDetailsManager;

import java.util.Collection;
import org.springframework.security.provisioning.UserDetailsManager;

public interface PracticalUserDetailsManager extends UserDetailsManager {

    Collection<PracticalUserDetails> getUsers();
    
}
