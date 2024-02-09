package com.tekgrp.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.tekgrp.user.service.entities.Rating;

/**
 * This interface represents the Rating Service, which is responsible for interacting with the Rating microservice.
 * It provides methods for creating, updating, and deleting ratings.
 * 
 * @author Gaurav Joshi
 */
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    /**
     * Creates a new rating.
     * 
     * @param values The rating values to be created.
     * @return The ResponseEntity containing the created rating.
     */
    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(Rating values);

    /**
     * Updates an existing rating.
     * 
     * @param ratingId The ID of the rating to be updated.
     * @param rating The updated rating.
     * @return The ResponseEntity containing the updated rating.
     */
    @PostMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, Rating rating);

    /**
     * Deletes a rating.
     * 
     * @param ratingId The ID of the rating to be deleted.
     * @param rating The rating to be deleted.
     * @return The ResponseEntity containing the deleted rating.
     */
    @PostMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> deleteRating (@PathVariable String ratingId, Rating rating);
}
