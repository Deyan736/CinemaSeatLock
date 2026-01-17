package com.cinemaseatlock.cinemaseatlock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 409 - seat lock conflict
    @ExceptionHandler(SeatAlreadyLockedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleSeatAlreadyLocked(SeatAlreadyLockedException ex) {
        return Map.of("error", ex.getMessage());
    }

    // 404 - not found
    @ExceptionHandler(SeatNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleSeatNotFound(SeatNotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }

    // 409 - reservation conflicts
    @ExceptionHandler({
            SeatMustBeLockedException.class,
            SeatAlreadySoldException.class,
            SeatAlreadyHasReservationException.class
    })
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleReservationConflict(RuntimeException ex) {
        return Map.of("error", ex.getMessage());
    }

    // 400 - bad request
    @ExceptionHandler(InvalidEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleInvalidEmail(InvalidEmailException ex) {
        return Map.of("error", ex.getMessage());
    }

    // fallback (da ne bude 500 bez poruke)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleIllegalArgument(IllegalArgumentException ex) {
        return Map.of("error", ex.getMessage());
    }
}
