package com.cinemaseatlock.cinemaseatlock.exception;

public class SeatMustBeLockedException extends RuntimeException {
    public SeatMustBeLockedException(Long seatId) {
        super("Seat must be LOCKED before reservation: " + seatId);
    }
}
