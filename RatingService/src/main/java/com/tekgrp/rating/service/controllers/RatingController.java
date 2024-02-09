package com.tekgrp.rating.service.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tekgrp.rating.service.entities.Rating;
import com.tekgrp.rating.service.services.RatingService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This class represents the Rating Controller which handles the HTTP requests related to ratings.
 * It provides endpoints for creating ratings, retrieving all ratings, and retrieving ratings by user or hotel.
 * 
 * @author Gaurav Joshi
 * @since Feb 03, 2024
 */
@RestController
@RequestMapping("/ratings")
@CrossOrigin(origins = "*")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    /**
     * Creates a new rating.
     * 
     * @param rating The rating object to be created.
     * @return The ResponseEntity containing the created rating.
     */
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    /**
     * Retrieves all ratings.
     * 
     * @return The ResponseEntity containing the list of all ratings.
     */
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getRatings());
    }
    
    /**
     * Retrieves ratings by user id.
     * 
     * @param userId The user id to filter the ratings.
     * @return The ResponseEntity containing the list of ratings filtered by user id.
     */
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingUserById(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    /**
     * Retrieves ratings by hotel id.
     * 
     * @param hotelId The hotel id to filter the ratings.
     * @return The ResponseEntity containing the list of ratings filtered by hotel id.
     */
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingHotelById(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
    
}
