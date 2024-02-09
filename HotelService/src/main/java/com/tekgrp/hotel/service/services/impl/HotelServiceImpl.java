package com.tekgrp.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekgrp.hotel.service.entities.Hotel;
import com.tekgrp.hotel.service.exceptions.ResourceNotFoundException;
import com.tekgrp.hotel.service.repositories.HotelRepository;
import com.tekgrp.hotel.service.services.HotelService;

/**
 * Implementation of the HotelService interface.
 * Provides methods for creating, retrieving, updating, and deleting hotels.
 * 
 * @author Gaurav Joshi
 * @since January 28, 2024
 */
@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * Creates a new hotel.
     * Generates a unique ID for the hotel and saves it to the repository.
     * 
     * @param hotel The hotel to be created.
     * @return The created hotel.
     */
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    /**
     * Retrieves all hotels.
     * 
     * @return A list of all hotels.
     */
    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    /**
     * Retrieves a hotel by its ID.
     * 
     * @param hotelId The ID of the hotel to retrieve.
     * @return The hotel with the specified ID.
     * @throws ResourceNotFoundException If the hotel with the given ID is not found.
     */
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id is not found on the server !!"+hotelId));
    }

    /**
     * Deletes a hotel by its ID.
     * 
     * @param hotelId The ID of the hotel to delete.
     * @throws UnsupportedOperationException This method is not implemented.
     */
    @Override
    public void deleteHotel(String hotelId) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteHotel'");
    }

    /**
     * Updates a hotel.
     * 
     * @param hotel The hotel to update.
     * @return The updated hotel.
     * @throws UnsupportedOperationException This method is not implemented.
     */
    @Override
    public Hotel updateHotel(Hotel hotel) {
        throw new UnsupportedOperationException("Unimplemented method 'updateHotel'");
    }
    
}
