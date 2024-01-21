package com.example.amadeus.repository;

import com.example.amadeus.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    Airport findByCity(String city);
}
