# CinemaSeatLock

Simple Spring Boot REST API for seat locking and reservations.

## Tech
- Java + Spring Boot
- Spring Data JPA + H2 (in-memory)
- springdoc-openapi (Swagger UI)

## Run
1. Start the app from IntelliJ or:
    - `./mvnw spring-boot:run`
2. Open Swagger UI:
    - `http://localhost:8080/swagger-ui/index.html`

## Endpoints

### Health
- `GET /health`

### Seats
- `GET /seats` – list all seats
- `POST /seats/{seatId}/lock` – lock seat for a limited time
    - returns `200 OK` when locked
    - returns `409 Conflict` if seat is already locked/sold/reserved (depending on logic)

### Reservations
- `POST /reservations`
  Request body:
```json
{
  "seatId": 1,
  "email": "test@mail.com"
}
