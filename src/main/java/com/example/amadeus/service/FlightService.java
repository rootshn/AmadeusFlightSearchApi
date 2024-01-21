// FlightService.java

package com.example.amadeus.service;

import com.example.amadeus.entity.Flight;
import com.example.amadeus.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    // Create Flight
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Read
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    // Update
    public Flight updateFlight(Long id, Flight flight) {
        return flightRepository.save(flight);
    }

    // Delete
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
