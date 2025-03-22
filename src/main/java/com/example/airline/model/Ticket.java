package com.example.airline.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passengerName;
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)  // Ensure correct foreign key mapping
    private Flight flight;
}
