package com.tekgrp.hotel.service.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.tekgrp.hotel.service.entities.Hotel;
import com.tekgrp.hotel.service.services.HotelService;
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
 * This class represents the controller for handling hotel-related requests.
 * It provides endpoints for creating a hotel, retrieving a hotel by ID, and retrieving all hotels.
 * 
 * @author Gaurav Joshi
 * @since January 28, 2024
 */
@RestController
@RequestMapping("/hotels")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    /**
     * Creates a new hotel.
     * 
     * @param hotel The hotel object to be created.
     * @return The ResponseEntity with the created hotel and HTTP status code 201 (Created).
     */
    @PostMapping()
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }
    
    /**
     * Retrieves a hotel by its ID.
     * 
     * @param hotelId The ID of the hotel to retrieve.
     * @return The ResponseEntity with the retrieved hotel and HTTP status code 200 (OK).
     */
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        return ResponseEntity.ok(hotelService.getHotelById(hotelId));
    }

    /**
     * Retrieves all hotels.
     * 
     * @return The ResponseEntity with the list of all hotels and HTTP status code 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok(hotelService.getAll());
    }
}
