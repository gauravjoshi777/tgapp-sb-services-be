/**
 * This class represents the main entry point of the User Service application.
 * It enables Feign Clients and starts the Spring Boot application.
 *
 * @author Gaurav Joshi
 * @since January 23, 2024
 */
package com.tekgrp.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
