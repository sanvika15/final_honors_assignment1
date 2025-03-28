# Airline Management System

## Overview
The Airline Management System is a Spring Boot-based application that allows users to:
- Retrieve flight schedules
- Get ticket details
- Book tickets
- Cancel tickets

All necessary validations are implemented to prevent duplication and ensure correctness.

---

## API Endpoints

### Flights

#### Create a Flight
**Endpoint:** `POST /flights`
**URL:** `http://localhost:8081/flights`
**Headers:**  
- `Content-Type: application/json`

**Request Body:**
```json
{
    "flightNumber": "AI202",
    "origin": "Mumbai",
    "destination": "Delhi",
    "departureTime": "2025-03-22T10:00:00",
    "arrivalTime": "2025-03-22T12:30:00"
}
```
**Response:**
```json
{
    "id": 1,
    "flightNumber": "AI202",
    "origin": "Mumbai",
    "destination": "Delhi",
    "departureTime": "2025-03-22T10:00:00",
    "arrivalTime": "2025-03-22T12:30:00"
}
```

#### Get All Flights
**Endpoint:** `GET /flights`
**URL:** `http://localhost:8081/flights`

**Response:**
```json
[
    {
        "id": 1,
        "flightNumber": "AI202",
        "origin": "Mumbai",
        "destination": "Delhi",
        "departureTime": "2025-03-22T10:00:00",
        "arrivalTime": "2025-03-22T12:30:00"
    }
]
```

#### Get Flight by ID
**Endpoint:** `GET /flights/{id}`
**URL:** `http://localhost:8081/flights/2`

**Response:**
```json
{
    "id": 2,
    "flightNumber": "AI203",
    "origin": "Bangalore",
    "destination": "Chennai",
    "departureTime": "2025-03-22T14:00:00",
    "arrivalTime": "2025-03-22T15:30:00"
}
```

#### Get Sorted Flights
**Endpoint:** `GET /flights?sort=asc`
**URL:** `http://localhost:8081/flights?sort=asc`

---

### Tickets

#### Book a Ticket
**Endpoint:** `POST /tickets`
**URL:** `http://localhost:8081/tickets`
**Headers:**
- `Content-Type: application/json`

**Request Body:**
```json
{
    "passengerName": "Sanvika Dakhale",
    "seatNumber": "12A",
    "flight": {
        "id": 1
    }
}
```
**Response:**
```json
{
    "id": 1,
    "passengerName": "Sanvika Dakhale",
    "seatNumber": "12A",
    "flight": {
        "id": 1,
        "flightNumber": "AI202",
        "origin": "Mumbai",
        "destination": "Delhi",
        "departureTime": "2025-03-22T10:00:00",
        "arrivalTime": "2025-03-22T12:30:00"
    }
}
```

#### Get Ticket by ID
**Endpoint:** `GET /tickets/{id}`
**URL:** `http://localhost:8081/tickets/1`

**Response:**
```json
{
    "id": 1,
    "passengerName": "Sanvika Dakhale",
    "seatNumber": "12A",
    "flight": {
        "id": 1,
        "flightNumber": "AI202",
        "origin": "Mumbai",
        "destination": "Delhi",
        "departureTime": "2025-03-22T10:00:00",
        "arrivalTime": "2025-03-22T12:30:00"
    }
}
```

#### Cancel Ticket
**Endpoint:** `DELETE /tickets/{id}`
**URL:** `http://localhost:8081/tickets/1`

**Response:**
```json
{
    "message": "Ticket with ID 1 has been cancelled successfully."
}
```

---

## Validations & Error Handling
- **Duplicate Booking:** A user cannot book the same flight twice.
- **Flight Availability Check:** Ensures flights exist before booking.
- **Date Format Validation:** Checks for correct date format in schedules.
- **Valid Ticket ID:** Ensures tickets exist before fetching or deleting.

---

## Technologies Used
- Java Spring Boot
- Hibernate/JPA
- MySQL/PostgreSQL (Database)
- REST API
- Swagger (API Documentation)

---

## Future Enhancements
- User authentication & authorization
- Seat selection feature
- Payment gateway integration

