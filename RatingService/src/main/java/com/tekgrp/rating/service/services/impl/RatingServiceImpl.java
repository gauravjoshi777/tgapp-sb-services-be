package com.tekgrp.rating.service.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tekgrp.rating.service.entities.Rating;
import com.tekgrp.rating.service.repositories.RatingRepository;
import com.tekgrp.rating.service.services.RatingService;

/**
 * This class implements the RatingService interface and provides the implementation for various rating operations.
 * 
 * @author Gaurav Joshi
 * @since Feb 03, 2024
 */
@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    /**
     * Creates a new rating.
     * 
     * @param rating The rating object to be created.
     * @return The created rating object.
     */
    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);   
    }

    /**
     * Retrieves all ratings.
     * 
     * @return A list of all ratings.
     */
    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    /**
     * Retrieves ratings by user ID.
     * 
     * @param userId The ID of the user.
     * @return A list of ratings associated with the specified user ID.
     */
    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    /**
     * Retrieves ratings by hotel ID.
     * 
     * @param hotelId The ID of the hotel.
     * @return A list of ratings associated with the specified hotel ID.
     */
    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    /**
     * Deletes a hotel by ID.
     * 
     * @param hotelId The ID of the hotel to be deleted.
     * @throws UnsupportedOperationException This method is not implemented.
     */
    @Override
    public void deleteHotel(String hotelId) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteHotel'");
    }

    /**
     * Updates a hotel.
     * 
     * @param hotel The updated hotel object.
     * @return The updated hotel object.
     * @throws UnsupportedOperationException This method is not implemented.
     */
    @Override
    public Rating updateHotel(Rating hotel) {
        throw new UnsupportedOperationException("Unimplemented method 'updateHotel'");
    }
}