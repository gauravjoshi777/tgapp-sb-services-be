package com.tekgrp.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tekgrp.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handles the exception when a resource is not found.
     * @author Gaurav Joshi
     * @date 20-01-2024
     * @param ex The ResourceNotFoundException object.
     * @return ResponseEntity containing the ApiResponse with the error message, success status, and HTTP status code.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }   


    
}
