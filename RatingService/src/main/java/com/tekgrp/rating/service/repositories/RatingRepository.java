package com.tekgrp.rating.service.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tekgrp.rating.service.entities.Rating;

/**
 * This interface represents the repository for managing Rating entities in the database.
 * It extends the MongoRepository interface provided by Spring Data MongoDB.
 * 
 * @author Gaurav Joshi
 * @since 2024-02-03
 */
public interface RatingRepository extends MongoRepository<Rating, String>{
    
    /**
     * Finds all ratings associated with the given user ID.
     * 
     * @param userId the user ID
     * @return a list of ratings associated with the user ID
     */
    List<Rating> findByUserId(String userId);

    /**
     * Finds all ratings associated with the given hotel ID.
     * 
     * @param hotelId the hotel ID
     * @return a list of ratings associated with the hotel ID
     */
    List<Rating> findByHotelId(String hotelId);
}
