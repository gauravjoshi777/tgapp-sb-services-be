package com.tekgrp.hotel.service.services;

import com.tekgrp.hotel.service.entities.Hotel;
import java.util.List;

/**
 * This interface represents the Hotel Service.
 * It provides methods for creating, retrieving, updating, and deleting hotels.
 * 
 * @author Gaurav Joshi
 * @since January 28, 2024
 */
public interface HotelService {

    /**
     * Creates a new hotel.
     * 
     * @param hotel The hotel to be created.
     * @return The created hotel.
     */
    Hotel create(Hotel hotel);

    /**
     * Retrieves all hotels.
     * 
     * @return A list of all hotels.
     */
    List<Hotel> getAll();

    /**
     * Retrieves a hotel by its ID.
     * 
     * @param hotelId The ID of the hotel to retrieve.
     * @return The hotel with the specified ID, or null if not found.
     */
    Hotel getHotelById(String hotelId);

    /**
     * Deletes a hotel by its ID.
     * 
     * @param hotelId The ID of the hotel to delete.
     */
    void deleteHotel(String hotelId);

    /**
     * Updates a hotel.
     * 
     * @param hotel The hotel to update.
     * @return The updated hotel.
     */
    Hotel updateHotel(Hotel hotel);

}
