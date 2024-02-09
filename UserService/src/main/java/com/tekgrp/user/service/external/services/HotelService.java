package com.tekgrp.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.tekgrp.user.service.entities.Hotel;

/**
 * This interface represents the Feign client for the Hotel Service.
 * It provides methods to interact with the Hotel Service API.
 * 
 * @author Gaurav Joshi
 */
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    
    /**
     * Retrieves the hotel information for the given hotel ID.
     * 
     * @param hotelId the ID of the hotel
     * @return the Hotel object containing the hotel information
     */
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

}
