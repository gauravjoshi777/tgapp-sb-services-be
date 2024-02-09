package com.tekgrp.rating.service.services;

import com.tekgrp.rating.service.entities.Rating;
import java.util.List;

/**
 * This interface represents the Rating Service, which provides operations for managing ratings.
 * 
 * @author Gaurav Joshi
 * @since Feb 02, 2024
 */
public interface RatingService {

    /**
     * Creates a new rating.
     * 
     * @param rating The rating to be created.
     * @return The created rating.
     */
    Rating create(Rating rating);

    /**
     * Retrieves all ratings.
     * 
     * @return A list of all ratings.
     */
    List<Rating> getRatings();

    /**
     * Retrieves ratings for a given user ID.
     * 
     * @param userId The ID of the user.
     * @return A list of ratings for the given user ID.
     */
    List<Rating> getRatingByUserId(String userId);

    /**
     * Retrieves ratings for a given hotel ID.
     * 
     * @param hotelId The ID of the hotel.
     * @return A list of ratings for the given hotel ID.
     */
    List<Rating> getRatingByHotelId(String hotelId);

    /**
     * Deletes a hotel by its ID.
     * 
     * @param hotelId The ID of the hotel to be deleted.
     */
    void deleteHotel(String hotelId);

    /**
     * Updates a hotel.
     * 
     * @param hotel The updated hotel.
     * @return The updated rating.
     */
    Rating updateHotel(Rating hotel);

}
