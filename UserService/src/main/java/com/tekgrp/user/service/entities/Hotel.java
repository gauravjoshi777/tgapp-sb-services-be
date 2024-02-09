package com.tekgrp.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a hotel entity.
 * 
 * @author Gaurav Joshi
 * @date 20-01-2024
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private String id;
    private String name;
    private String location;
    private String about;
}
