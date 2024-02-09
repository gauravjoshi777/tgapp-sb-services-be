package com.tekgrp.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tekgrp.user.service.entities.Hotel;
import com.tekgrp.user.service.entities.Rating;
import com.tekgrp.user.service.entities.User;
import com.tekgrp.user.service.exceptions.ResourceNotFoundException;
import com.tekgrp.user.service.external.services.HotelService;
import com.tekgrp.user.service.repositories.UserRepository;
import com.tekgrp.user.service.services.UserService;

/**
 * This class implements the UserService interface and provides the implementation for various user-related operations.
 * 
 * @author Gaurav Joshi
 * @since January 23, 2024
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * Saves a new user in the database.
     *
     * @param user The user to be saved.
     * @return The saved user.
     */
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    /**
     * Retrieves all users from the database.
     *
     * @return A list of all users.
     */
    @Override
    public List<User> getAllUser() {
        // Implement rating service call using RestTemplate
        return userRepository.findAll();
    }

    /**
     * Retrieves a user from the database by their user ID.
     * Fetches the user's ratings from the RATING-SERVICE.
     *
     * @param userId The ID of the user to retrieve.
     * @return The retrieved user with their ratings.
     * @throws ResourceNotFoundException If the user with the given ID is not found.
     */
    @Override
    public User getUser(String userId) {
        // Get user from database with the help of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on the server !!" + userId));
        // Fetch rating of the above user from RATING-SERVICE
        // http://localhost:9093/ratings/users/27aea55d-a856-432e-b62e-f710dc44fc52
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{} ", ratingsOfUser);

        List<Rating> ratings  = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            // API cal to hotel service to get hotel
            //http://localhost:9092/hotels/652f3b08-2dd5-4ba7-8e46-c8d50c10c632
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
           // logger.info("Response status code {} "+forEntity.getStatusCode());
            // set the hotel to rating
            rating.setHotel(hotel);
            // return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public void deleteUser(String userId) {
        // TODO Auto-generated method stub
    }

    @Override
    public User updateUser(User user) {
        // TODO Auto-generated method stub
        return null;
    }
}
