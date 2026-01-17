package com.cinemaseatlock.cinemaseatlock.service;

import com.cinemaseatlock.cinemaseatlock.entity.*;
import com.cinemaseatlock.cinemaseatlock.exception.*;
import com.cinemaseatlock.cinemaseatlock.repository.ReservationRepository;
import com.cinemaseatlock.cinemaseatlock.repository.SeatRepository;
import org.springframework.dao.DataIntegrityViolationException;
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
        validateEmail(email);

        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new SeatNotFoundException(seatId));

        Instant now = Instant.now();
        seat.unlockIfExpired(now);

        ensureSeatCanBeReserved(seat);

        Reservation reservation = new Reservation(seat, email);

        try {
            Reservation saved = reservationRepository.save(reservation);
            seat.markSold(); // JPA managed entity -> update ide u istoj transakciji
            return saved;
        } catch (DataIntegrityViolationException ex) {
            // Ako ima unique constraint nad seat_id, ovo hvata paralelne request-ove
            throw new SeatAlreadyHasReservationException(seatId);
        }
    }

    private static void ensureSeatCanBeReserved(Seat seat) {
        if (seat.getStatus() != SeatStatus.LOCKED) {
            throw new SeatMustBeLockedException(seat.getId());
        }
        if (seat.getStatus() == SeatStatus.SOLD) {
            throw new SeatAlreadySoldException(seat.getId());
        }
    }

    private static void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new InvalidEmailException(email);
        }
    }
}
