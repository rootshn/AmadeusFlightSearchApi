package com.example.amadeus.service;

import com.example.amadeus.entity.Airport;
import com.example.amadeus.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    // Create a new airport
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    // Get a single airport by ID
    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    // Get all airports
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    // Update an airport
    public Airport updateAirport(Long id, Airport airportDetails) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Airport with id " + id + " does not exist"));

        airport.setCity(airportDetails.getCity());
        // Update other fields as needed

        return airportRepository.save(airport);
    }

    // Delete an airport
    public void deleteAirport(Long id) {
        boolean exists = airportRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Airport with id " + id + " does not exist");
        }
        airportRepository.deleteById(id);
    }
}
