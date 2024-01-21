package com.example.amadeus.controller;

import com.example.amadeus.entity.Airport;
import com.example.amadeus.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    // Create a new airport
    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        Airport newAirport = airportService.createAirport(airport);
        return ResponseEntity.ok(newAirport);
    }

    // Get a single airport by ID
    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        return airportService.getAirportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all airports
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    // Update an airport
    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable Long id, @RequestBody Airport airportDetails) {
        Airport updatedAirport = airportService.updateAirport(id, airportDetails);
        return ResponseEntity.ok(updatedAirport);
    }

    // Delete an airport
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
        return ResponseEntity.ok().build();
    }
}
