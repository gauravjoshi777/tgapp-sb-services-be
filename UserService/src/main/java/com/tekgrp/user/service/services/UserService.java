package com.tekgrp.user.service.services;

import com.tekgrp.user.service.entities.User;
import java.util.List;

/**
 * This interface represents the UserService, which provides operations for managing users.
 * 
 * @author Gaurav Joshi
 * @since January 23, 2024
 */
public interface UserService {

    /**
     * Saves a user in the system.
     * 
     * @param user the user to be saved
     * @return the saved user
     */
    User saveUser(User user);

    /**
     * Retrieves all users in the system.
     * 
     * @return a list of all users
     */
    List<User> getAllUser();

    /**
     * Retrieves a user based on the given user ID.
     * 
     * @param userId the ID of the user to retrieve
     * @return the user with the given ID, or null if not found
     */
    User getUser(String userId);

    /**
     * Deletes a user based on the given user ID.
     * 
     * @param userId the ID of the user to delete
     */
    void deleteUser(String userId);

    /**
     * Updates a user in the system.
     * 
     * @param user the user to be updated
     * @return the updated user
     */
    User updateUser(User user);

}
