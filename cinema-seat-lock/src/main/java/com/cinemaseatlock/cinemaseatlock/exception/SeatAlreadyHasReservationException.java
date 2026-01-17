package com.cinemaseatlock.cinemaseatlock.exception;

public class SeatAlreadyHasReservationException extends RuntimeException {
    public SeatAlreadyHasReservationException(Long seatId) {
        super("Seat already has active reservation: " + seatId);
    }
}
