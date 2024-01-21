package com.example.amadeus.repository;

import com.example.amadeus.entity.Airport;
import com.example.amadeus.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTime(
            Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDateTime);

    List<Flight> findByDepartureAirportAndArrivalAirport(
            Airport departureAirport, Airport arrivalAirport);

    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDateTimeAndReturnDateTime(
            Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDateTime, LocalDateTime returnDateTime);
}