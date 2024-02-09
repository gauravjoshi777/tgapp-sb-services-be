/**
 * This package contains the controllers for the user service.
 * These controllers handle the incoming HTTP requests related to user operations.
 *
 * @author Gaurav Joshi
 * @date 16-01-2024
 */
package com.tekgrp.user.service.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.tekgrp.user.service.entities.User;
import com.tekgrp.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

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

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * The code you've provided is part of a RESTful API written in Java, specifically a method for creating a new `User` object.
     * The `createUser` method is a public method that returns an instance of `ResponseEntity<User>`. `ResponseEntity` is a class in Spring Framework that represents the entire HTTP response: status code, headers, and body. It's used in a controller to define what to return as a response to an HTTP request.
     *
     * The `createUser` method takes one parameter, `user`, which is annotated with `@RequestBody`. This annotation is used to indicate that the parameter should be bound to the body of the HTTP request. Spring's HTTP message converter mechanism will convert the incoming HTTP request body on the fly to the parameter type of your method, in this case, `User`.
     *
     * Inside the `createUser` method, the `saveUser` method of `userService` is called with the `user` parameter. This method generates a random UUID, sets it as the user's ID, and then saves the user to the database using `userRepository.save(user)`. The saved `User` object is returned and stored in the `user1` variable.
     *
     * Finally, a `ResponseEntity` is returned with a status of `HttpStatus.CREATED` (which corresponds to the HTTP status code 201), and the body of the response is set to the `User` object that was just saved. This means that when a client sends a request to this endpoint, they will receive a response that includes the details of the user that was just created, along with a status code indicating that the user was successfully created.
     *
     * The `status` and `body` methods are part of the `ResponseEntity` class in Spring Framework. The `status` method is a static method that returns a `BodyBuilder` instance with the status set to the provided `HttpStatusCode`. The `body` method is used to set the body of the response and returns a new `ResponseEntity` with the provided body, headers, and status code.
     */
    //Create
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    
    int retryCount = 1;

    // getUser by id
    /**
     * Retrieves a single user by their ID.
     *
     * @param userId the ID of the user to retrieve
     * @return a ResponseEntity containing the user if found, or an empty body with a status code of 404 if not found
     */
    @GetMapping("/{userId}")
    //@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    //@Retry(name="ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        logger.info("Retry Count: {}", retryCount);
        retryCount++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }


    // creating fallback method for circuitbreaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
        logger.info("Fallback is executed beacuse serivce is down : ",ex.getMessage());
        User user = User.builder()
                        .email("dummy@gmail.com")
                        .name("Dummy")
                        .about("This user is created dummy as some service is down ")
                        .userId("007")
                        .build();
        return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
    }


    /**
        * Retrieves all users.
        *
        * @return ResponseEntity<List<User>> containing all users
        */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUser =  userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

}
