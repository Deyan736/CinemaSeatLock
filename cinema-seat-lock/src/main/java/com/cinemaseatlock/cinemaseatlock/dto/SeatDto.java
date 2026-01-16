package com.cinemaseatlock.cinemaseatlock.dto;

import java.time.Instant;

public record SeatDto(
        Long id,
        String seatNumber,
        String status,
        Instant lockedUntil
) {}