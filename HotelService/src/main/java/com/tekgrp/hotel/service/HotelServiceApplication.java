/**
 * This is the main class for the Hotel Service application.
 * It initializes and runs the Spring Boot application.
 *
 * @author Gaurav Joshi
 * @since January 28, 2024
 */
package com.tekgrp.hotel.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class HotelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceApplication.class, args);
	}

}
