package com.cognizant.spring_learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/country/{code}")
    public String getCountry(@PathVariable String code) {

        if (code.equalsIgnoreCase("IN")) {
            return "{\"code\":\"IN\",\"name\":\"India\"}";
        }

        return "{\"message\":\"Country Not Found\"}";
    }
}