package com.jverstry.Data.PracticalUserDetails;

import java.util.Set;

public interface PracticalUserDetailsDAO<U extends PracticalUserDetails> {
    
    /**
     * Registers a new user. If the user already exists (i.e., with the
     * same id or username), or if the provided parameter is {@code null},
     * this method does nothing.
     * 
     * @param user the user to register 
     */
    void create(U user);

    /**
     * Indicates whether the provided user exists or not. If the provided
     * value is {@code null}, this method returns {@code false}.
     * 
     * @param user the user to check
     * @return {@code true} if the user exists, {@code false} otherwise
     */
    boolean contains(U user);
    
    /**
     * Retrieves a user from its user name. Returns {@code null} if the user
     * does not exist.
     * 
     * @param username the name of the user
     * @return a user or {@code null}
     */
    U read(String username);
    
    /**
     * Retrieves a user from its identifier. Returns {@code null} if the user
     * does not exist.
     * 
     * @param id the user identifier
     * @return a user or {@code null}
     */
    U read(long id);
    
    /**
     * Updates an existing user. This methods does nothing if 
     * if the user does not exist or if the provided value is {@code null}.
     * 
     * @param user the user to update
     */
    void update(U user);
    
    /**
     * Deletes a user from its user name.
     * 
     * @param username the name of the user
     */
    void delete(String username);
    
    /**
     * Deletes a user from its identifier.
     * 
     * @param id the user identifier
     */
    void delete(long id);
    
    interface UserIdentifiers {
        long getId();
        String getUsername();
    }

    /**
     * Provides the set of known users identifiers.
     * 
     * @return the set of know user identifiers 
     */
    Set<UserIdentifiers> getUsers();    
    
}
