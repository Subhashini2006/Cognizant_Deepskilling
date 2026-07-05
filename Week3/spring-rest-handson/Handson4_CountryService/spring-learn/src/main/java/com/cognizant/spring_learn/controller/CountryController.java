package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/country")
    public String getCountryIndia() {
        return "{\"code\":\"IN\",\"name\":\"India\"}";
    }
}