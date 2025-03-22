package com.example.airline.controller;

import com.example.airline.model.Flight;
import com.example.airline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")  // This ensures all endpoints are under "/flights"
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    // POST request to add a new flight
    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight savedFlight = flightRepository.save(flight);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    // GET request to fetch all flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    // GET request to fetch a flight by ID
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        return flight.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
