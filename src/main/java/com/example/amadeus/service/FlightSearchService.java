package com.example.amadeus.service;

import com.example.amadeus.entity.Airport;
import com.example.amadeus.entity.Flight;
import com.example.amadeus.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightSearchService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> searchFlights(Airport departureAirport, Airport arrivalAirport,
                                      LocalDateTime departureDateTime, LocalDateTime returnDateTime) {
        if (returnDateTime == null) {
            return flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTime(
                    departureAirport, arrivalAirport, departureDateTime);
        } else {
            List<Flight> oneWayFlights = flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTime(
                    departureAirport, arrivalAirport, departureDateTime);
            List<Flight> returnFlights = flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDateTime(
                    arrivalAirport, departureAirport, returnDateTime);

            oneWayFlights.addAll(returnFlights);
            return oneWayFlights;
        }
    }
}