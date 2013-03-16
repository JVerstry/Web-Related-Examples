package com.jverstry.UserDetailsManager;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.security.core.userdetails.memory.UserAttributeEditor;
import org.springframework.util.Assert;

public class InMemoryPracticalUserDetailsManager implements PracticalUserDetailsManager {
    
    private final Map<String,PracticalUserDetails> users
        = new HashMap<String,PracticalUserDetails>();

    private AuthenticationManager authenticationManager;

    public InMemoryPracticalUserDetailsManager(Collection<UserDetails> users) {
        for (UserDetails user : users) {
            this.users.put(user.getUsername(), new PracticalUserDetails(user));
        }
    }

    public InMemoryPracticalUserDetailsManager(Properties users) {
        Enumeration<?> names = users.propertyNames();
        UserAttributeEditor editor = new UserAttributeEditor();

        while(names.hasMoreElements()) {
            String name = (String) names.nextElement();
            editor.setAsText(users.getProperty(name));
            UserAttribute attr = (UserAttribute) editor.getValue();
            UserDetails user = new User(name, attr.getPassword(), attr.isEnabled(), true, true, true,
                    attr.getAuthorities());
            this.users.put(user.getUsername(), new PracticalUserDetails(user));
        }
    }

    @Override
    public void createUser(UserDetails user) {
        Assert.isTrue(!userExists(user.getUsername()));

        users.put(user.getUsername(), new PracticalUserDetails(user));
    }

    @Override
    public void deleteUser(String username) {
        users.remove(username);
    }

    @Override
    public void updateUser(UserDetails user) {
        Assert.isTrue(userExists(user.getUsername()));

        users.put(user.getUsername(), new PracticalUserDetails(user));
    }

    @Override
    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

        if (currentUser == null) {
            // This would indicate bad coding somewhere
            throw new AccessDeniedException("Can't change password as no Authentication object found in context " +
                    "for current user.");
        }

        String username = currentUser.getName();

        // If an authentication manager has been set, re-authenticate the user with the supplied password.
        if (authenticationManager != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        }
        
        PracticalUserDetails user = users.get(username);

        if (user == null) {
            throw new IllegalStateException("Current user doesn't exist in database.");
        }

        this.users.put(username, new PracticalUserDetails(
            user, newPassword, PracticalUserDetails.nextId()));
        
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = users.get(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
                user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public Collection<PracticalUserDetails> getUsers() {
        return this.users.values();
    }
    
}
