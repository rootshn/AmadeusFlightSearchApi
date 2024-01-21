package com.example.amadeus.repository;

import com.example.amadeus.entity.Airport;
import com.example.amadeus.entity.Flight;
import com.example.amadeus.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FlightSearchController {
    @Autowired
    private FlightSearchService flightSearchService;

    @GetMapping(value = "/searchFlights", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> searchFlights(
            @RequestParam Airport departureAirport,
            @RequestParam Airport arrivalAirport,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime returnDateTime) {

        return flightSearchService.searchFlights(departureAirport, arrivalAirport, departureDateTime, returnDateTime);
    }
}