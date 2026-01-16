package com.cinemaseatlock.cinemaseatlock.service;

import com.cinemaseatlock.cinemaseatlock.entity.*;
import com.cinemaseatlock.cinemaseatlock.repository.ReservationRepository;
import com.cinemaseatlock.cinemaseatlock.repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class ReservationService {

    private final SeatRepository seatRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(
            SeatRepository seatRepository,
            ReservationRepository reservationRepository
    ) {
        this.seatRepository = seatRepository;
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public Reservation createReservation(Long seatId, String email) {

        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new IllegalArgumentException("Seat not found"));

        Instant now = Instant.now();
        seat.unlockIfExpired(now);

        if (seat.getStatus() != SeatStatus.LOCKED) {
            throw new IllegalStateException("Seat must be LOCKED before reservation");
        }

        boolean alreadyReserved =
                reservationRepository.existsActiveReservation(seatId, ReservationStatus.CONFIRMED);

        if (alreadyReserved) {
            throw new IllegalStateException("Seat already has active reservation");
        }

        Reservation reservation = new Reservation(seat, email);
        reservationRepository.save(reservation);

        // potvrda kupovine
        seat.markSold();

        return reservation;
    }
}
