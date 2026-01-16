package com.cinemaseatlock.cinemaseatlock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SeatAlreadyLockedException.class)
    @ResponseStatus(HttpStatus.CONFLICT) // 409
    public Map<String, String> handleSeatAlreadyLocked(SeatAlreadyLockedException ex) {
        return Map.of("error", ex.getMessage());
    }
}
