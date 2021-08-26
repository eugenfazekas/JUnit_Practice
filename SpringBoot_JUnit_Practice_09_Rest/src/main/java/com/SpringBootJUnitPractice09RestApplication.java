package com;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.beans.FlightBuilder;
import com.model.Country;
import com.model.CountryRepository;
import com.model.Flight;
import com.model.Passenger;
import com.model.PassengerRepository;

@SpringBootApplication
@Import(FlightBuilder.class)
public class SpringBootJUnitPractice09RestApplication {
	
	@Autowired
	private Flight flight;

    @Autowired
    private Map<String, Country> countriesMap;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJUnitPractice09RestApplication.class, args);
	}
	
	 @Bean
	 CommandLineRunner configureRepository(CountryRepository countryRepository,
	                                          PassengerRepository passengerRepository) {
	        return args -> {

	            for (Country country : countriesMap.values()) {
	                countryRepository.save(country);
	            }

	            for (Passenger passenger : flight.getPassengers()) {
	                passengerRepository.save(passenger);
	            }
	        };
	    }

}

