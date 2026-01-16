package com.cinemaseatlock.cinemaseatlock.exception;

public class SeatAlreadyLockedException extends RuntimeException {
    public SeatAlreadyLockedException(Long seatId) {
        super("Seat " + seatId + " is already locked");
    }
}
