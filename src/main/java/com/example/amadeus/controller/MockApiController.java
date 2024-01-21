package com.example.amadeus.controller;

import com.example.amadeus.entity.Airport;
import com.example.amadeus.entity.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/mock-api")
public class MockApiController {

    @GetMapping("/flights")
    public List<Flight> getMockFlights() {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            Flight flight = new Flight();
            flight.setId((long) i);
            Airport departureAirport =new Airport();
            flight.setDepartureAirport(departureAirport);


            //Airport
            Airport arrivalAirport = new Airport();
            flight.setArrivalAirport(arrivalAirport);


            //Time
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime departureDateTime = now.plusDays(i).plusHours(random.nextInt(24)).plusMinutes(random.nextInt(60));
            LocalDateTime returnDateTime = departureDateTime.plusDays(random.nextInt(7)).plusHours(random.nextInt(24)).plusMinutes(random.nextInt(60));

            //Flight
            flight.setDepartureDateTime(departureDateTime);
            flight.setReturnDateTime(returnDateTime);

            double price = 100 + random.nextInt(300);
            flight.setPrice(price);
            flights.add(flight);
        }

        return flights;
    }
}