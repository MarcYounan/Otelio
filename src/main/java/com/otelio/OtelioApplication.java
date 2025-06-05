package com.otelio;

import com.otelio.service.HotelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OtelioApplication {

    public static void main(String[] args) {
        SpringApplication.run(OtelioApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(HotelService hotelService) {
        return args -> {
            hotelService.createSampleHotel();
        };
    }
}
