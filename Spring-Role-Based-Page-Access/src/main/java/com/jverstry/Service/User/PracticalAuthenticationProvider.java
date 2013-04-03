package com.jverstry.Service.User;

import com.jverstry.Data.PracticalUserDetails.PracticalUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("pap")
public class PracticalAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    PracticalUserDetailsServiceInMemory pudsim;
    
    public PracticalAuthenticationProvider() { }
    
    @Override
    @SuppressWarnings({"null", "ConstantConditions"})
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        
        if ( authentication == null ) return null;
        if ( !supports(authentication.getClass()) ) return null;
        
        UsernamePasswordAuthenticationToken retr
            = (UsernamePasswordAuthenticationToken) authentication;
        
        String principal = (String) retr.getPrincipal();
        String password = (String) retr.getCredentials();
        
        PracticalUserDetails user = null;
        
        try {
        
            user = pudsim.loadUserByUsername(principal);
            
        } catch(UsernameNotFoundException ex) {
            
             throw new BadCredentialsException(
                 principal + " principal not found", ex);
            
        }
        
        // Returned user is never null
        if ( !user.isEnabled() ) {
            throw new DisabledException("Username: " + user.getUsername());
        }
        
        if ( !user.isAccountNonLocked() ) {
            throw new LockedException("Username: " + user.getUsername());
        }
        
        if ( !user.getPassword().equals(password) ) {
            throw new BadCredentialsException("Username: " + user.getUsername());
        }
        
        return new UsernamePasswordAuthenticationToken(
            user.getUsername(), user.getPassword(), user.getAuthorities());
        
    }

    @Override
    public boolean supports(Class<?> authentication) {
        
        if ( authentication == null ) return false;
        
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
                
    }
    
    public static PracticalUserDetails getLoggedInUser() {
    
        // Anyone logged in?
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if ( auth == null ) {
            
            // Nope
            return null;
            
        } else {
            
            Object princ = auth.getPrincipal();

            if (princ instanceof PracticalUserDetails) {
                return (PracticalUserDetails) princ;
            } else {
                
                // That is a big bug !!!
                return null;
                
            }
            
        }
        
    }
        
}
