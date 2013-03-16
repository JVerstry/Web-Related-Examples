package com.jverstry.UserDetailsManager;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PracticalUserDetails implements UserDetails {
    
    private static final long serialVersionUID = 1L;

    private static final AtomicLong al = new AtomicLong(0);
    
    public static long nextId() {
        return al.incrementAndGet();
    }
    
    private final UserDetails delegated;
    private final long id;
    private String password;
    
    public PracticalUserDetails(UserDetails ud) {
        this.delegated = ud;
        this.password = ud.getPassword();
        this.id = nextId();
    }
    
    public PracticalUserDetails(UserDetails ud, String password, long id) {
        this.delegated = ud;
        this.password = password;
        this.id = id;
    }
    
    public long getId() {
        return this.id;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.delegated.getAuthorities();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.delegated.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.delegated.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.delegated.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.delegated.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.delegated.isEnabled();
    }
    
}
