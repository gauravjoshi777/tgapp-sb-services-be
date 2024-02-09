/**
 * This class represents the main entry point for the Rating Service application.
 * It initializes and starts the Spring Boot application.
 *
 * @author Gaurav Joshi
 * @since Feb 02, 2024
 */
package com.tekgrp.rating.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}

}
