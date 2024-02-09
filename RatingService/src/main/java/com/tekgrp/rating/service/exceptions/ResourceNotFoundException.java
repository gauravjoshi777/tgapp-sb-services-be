/**
 * Exception thrown when a requested resource is not found on the server.
 * 
 * @author Gaurav Joshi
 * @since Feb 03, 2024
 */
package com.tekgrp.rating.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
 
    public ResourceNotFoundException() {
        super("Resource Not found on server!!");
    }
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
