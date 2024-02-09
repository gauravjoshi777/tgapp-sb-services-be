package com.tekgrp.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tekgrp.user.service.entities.Rating;
import com.tekgrp.user.service.external.services.RatingService;

@SpringBootTest
@Service
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	@Test
	void ceateRating(){
		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is created using Feign client!").build();
		ResponseEntity<Rating> savedRating = ratingService.createRating(rating);
		System.out.println("New Rating Created!");
	}

}
