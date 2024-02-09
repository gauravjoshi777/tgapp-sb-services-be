package com.tekgrp.user.service.exceptions;

/**
 * Author: Gaurav Joshi
 * Date: 20-01-2024
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource Not found on server!!");
    }
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
