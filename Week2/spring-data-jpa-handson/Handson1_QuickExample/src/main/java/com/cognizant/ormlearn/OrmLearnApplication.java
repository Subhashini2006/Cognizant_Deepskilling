package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CountryService service) {
        return args -> {
            List<Country> countries = service.getAllCountries();

            System.out.println("===== Country List =====");

            for (Country country : countries) {
                System.out.println(country);
            }
        };
    }
}