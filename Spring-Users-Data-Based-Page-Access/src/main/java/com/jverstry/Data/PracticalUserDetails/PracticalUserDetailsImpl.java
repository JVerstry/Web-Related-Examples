package com.jverstry.Data.PracticalUserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.security.core.GrantedAuthority;

public class PracticalUserDetailsImpl implements PracticalUserDetails {
    
    private static final long serialVersionUID = 1L;

    private static final AtomicLong al = new AtomicLong(0);
    
    public static long nextId() {
        return al.incrementAndGet();
    }
    
    private final long id;
    private final String username;
    private String password;
    
    private Collection<? extends GrantedAuthority> authorities
        = getEmptyRoles();
    
    private boolean accountExpired = false;
    private boolean accountLocked = false;
    private boolean credentialsExpired = false;
    private boolean enabled = true;
    
    public PracticalUserDetailsImpl(String username, String password) {
        
        this.id = nextId();
        this.username = username;
        this.password = password;
        
    }
    
    @Override
    public final long getId() {
        return this.id;
    }
    
    public static Collection<? extends GrantedAuthority> getEmptyRoles() {
        
        ArrayList<GrantedAuthority> result
            = new ArrayList<GrantedAuthority>();
        
        return result;
        
    }    

    @Override
    @SuppressWarnings("ReturnOfCollectionOrArrayField")
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public void eraseCredentials() {
        this.authorities.clear();
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setAccountExpired(boolean b) {
        this.accountExpired = b;
    }

    @Override
    public void setAccountLocked(boolean b) {
        this.accountLocked = b;
    }

    @Override
    public void setCredentialsExpired(boolean b) {
        this.credentialsExpired = b;
    }

    @Override
    public void setEnabled(boolean b) {
        this.enabled = b;
    }

    @Override
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
}