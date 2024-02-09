package com.tekgrp.user.service.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents the response of an API request.
 * @author Gaurav Joshi
 * @date 20-01-2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    
    /**
     * The message associated with the API response.
     */
    private String message;
    
    /**
     * Indicates whether the API request was successful or not.
     */
    private Boolean success;
    
    /**
     * The HTTP status code of the API response.
     */
    private HttpStatus status;
    
}