package com.cinemaseatlock.cinemaseatlock.service;

import com.cinemaseatlock.cinemaseatlock.entity.Seat;
import com.cinemaseatlock.cinemaseatlock.entity.SeatStatus;
import com.cinemaseatlock.cinemaseatlock.repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cinemaseatlock.cinemaseatlock.exception.SeatAlreadyLockedException;


import java.time.Duration;
import java.time.Instant;

@Service
public class SeatLockService {

    private final SeatRepository seatRepository;
    private static final Duration LOCK_DURATION = Duration.ofMinutes(5);

    public SeatLockService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Transactional
    public Seat lockSeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new IllegalArgumentException("Seat not found: " + seatId));

        Instant now = Instant.now();
        seat.unlockIfExpired(now);

        if (seat.getStatus() == SeatStatus.SOLD) {
            throw new IllegalStateException("Seat already sold");
        }

        if (seat.getStatus() == SeatStatus.TEMP_RESERVED) {
            throw new IllegalStateException("Seat already temporarily reserved");
        }

        if (seat.getStatus() == SeatStatus.LOCKED) {
            throw new SeatAlreadyLockedException(seatId);
        }


        seat.lockUntil(now.plus(LOCK_DURATION));
        return seat;
    }
}
