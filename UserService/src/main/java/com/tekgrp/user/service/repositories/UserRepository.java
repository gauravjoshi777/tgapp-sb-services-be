/**
 * This interface represents a repository for managing User entities.
 * It extends the JpaRepository interface, providing CRUD operations for User entities.
 */
package com.tekgrp.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekgrp.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
    
}
