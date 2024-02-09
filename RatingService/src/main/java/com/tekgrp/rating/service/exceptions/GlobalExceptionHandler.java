package com.tekgrp.rating.service.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class handles global exceptions for the rating service.
 * It provides exception handling for the ResourceNotFoundException.
 * 
 * @author Gaurav Joshi
 * @since Feb 03, 2024
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handles the ResourceNotFoundException and returns a ResponseEntity with appropriate status and message.
     * 
     * @param ex the ResourceNotFoundException to be handled
     * @return a ResponseEntity with status, message, and success flag
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException ex){
        Map map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("success", false);
        map.put("status", HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }   
}
