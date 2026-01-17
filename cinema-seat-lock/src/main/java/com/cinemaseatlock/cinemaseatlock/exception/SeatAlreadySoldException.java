package com.cinemaseatlock.cinemaseatlock.exception;

public class SeatAlreadySoldException extends RuntimeException {
    public SeatAlreadySoldException(Long seatId) {
        super("Seat already sold: " + seatId);
    }
}
