package com.jverstry.DAO;

import java.util.Collection;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public interface PracticalUserDetails extends UserDetails, CredentialsContainer {

    long getId();
    
    void setPassword(String password);
    
    void setAccountExpired(boolean b);

    void setAccountLocked(boolean b);

    void setCredentialsExpired(boolean b);

    void setEnabled(boolean b);
    
    void setAuthorities(Collection<? extends GrantedAuthority> authorities);    

}
