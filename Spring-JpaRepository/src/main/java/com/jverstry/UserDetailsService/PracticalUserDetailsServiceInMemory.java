package com.jverstry.UserDetailsService;

import com.jverstry.DAO.PracticalUserDetails;
import com.jverstry.DAO.PracticalUserDetailsDAO;
import com.jverstry.DAO.PracticalUserDetailsDAOInMemory;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("practicalUserDetailsServiceInMemory")
public class PracticalUserDetailsServiceInMemory implements PracticalUserDetailsService {

    @Autowired
    private PracticalUserDetailsDAOInMemory pud; 
    
    public PracticalUserDetailsServiceInMemory() { }

    @Override
    public void deleteUser(long id) {
        this.pud.delete(id);
    }

    @Override
    public void upsertUser(PracticalUserDetails user) {
        
        if ( this.pud.contains(user) ) {
            this.pud.update(user);
        } else {
            this.pud.create(user);
        }
        
    }
    
    @Override
    public PracticalUserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        
        PracticalUserDetails retr = this.pud.read(username);
        
        if ( retr == null )
            throw new UsernameNotFoundException(username);
        
        return retr;
        
    }

    @Override
    public PracticalUserDetails getUser(long id) {
        return this.pud.read(id);
    }

    @Override
    public PracticalUserDetails getUser(String username) {
        return this.pud.read(username);
    }

    @Override
    public Set<PracticalUserDetailsDAO.UserIdentifiers> getUsers() {
        return this.pud.getUsers();
    }

}
