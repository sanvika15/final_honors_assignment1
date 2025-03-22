package com.example.airline.controller;

import com.example.airline.model.Ticket;
import com.example.airline.repository.TicketRepository;
import com.example.airline.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tickets")  //  This ensures all URLs start with /tickets
public class TicketController {

    @Autowired
    private TicketService ticketService;

    //  POST - Book a new ticket
    @PostMapping
    public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.bookTicket(ticket);
        return ResponseEntity.ok(savedTicket);
    }

    //  GET - Retrieve ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //  DELETE - Cancel a ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelTicket(@PathVariable Long id) {
        boolean deleted = ticketService.cancelTicket(id);
        if (deleted) {
            return ResponseEntity.ok("Ticket cancelled successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
