/**
 * This interface represents the repository for the Hotel entity.
 * It extends the JpaRepository interface to inherit basic CRUD operations.
 * 
 * @author Gaurav Joshi
 * @since 2024-01-28
 */
package com.tekgrp.hotel.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tekgrp.hotel.service.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{
    
}
