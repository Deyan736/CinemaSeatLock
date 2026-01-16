# Cinema Seat Lock API

Spring Boot application that demonstrates a safe cinema seat reservation flow using a temporary locking mechanism to prevent race conditions.

## Features

- Temporary seat locking
- Final seat reservation
- Conflict handling (HTTP 409)
- Audit logging
- Swagger / OpenAPI documentation
- In-memory H2 database

## Reservation Flow

1. Lock a seat temporarily  
   POST /seats/{seatId}/lock  

   - Locks a seat for a limited time  
   - Returns 409 Conflict if the seat is already locked or sold  

2. Create a reservation (final purchase)  
   POST /reservations  

   Example request body:
   ```json
   {
     "seatId": 1,
     "email": "test@mail.com"
   }
