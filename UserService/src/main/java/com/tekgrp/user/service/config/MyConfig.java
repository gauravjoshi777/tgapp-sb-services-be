/**
 * This class represents the configuration for the User Service.
 * It provides beans for RestTemplate and WebMvcConfigurer.
 * The RestTemplate bean is annotated with @LoadBalanced for load balancing.
 * The WebMvcConfigurer bean is used for configuring CORS mappings.
 * 
 * @author Gaurav Joshi
 * @date 16-01-2024
 */
package com.tekgrp.user.service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig {
    @Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


	// @Bean
    // public WebMvcConfigurer corsConfigurer() {
    //     return new WebMvcConfigurer() {
    //         @Override
    //         public void addCorsMappings(CorsRegistry registry) {
    //             registry.addMapping("/").allowedOrigins("http://localhost:3001");
    //         }
    //     };
    // }
}
