package com.cinemaseatlock.cinemaseatlock.dto;

import java.time.Instant;

public class SeatLockResponseDto {
    private final Long seatId;
    private final String status;
    private final Instant lockedUntil;

    public SeatLockResponseDto(Long seatId, String status, Instant lockedUntil) {
        this.seatId = seatId;
        this.status = status;
        this.lockedUntil = lockedUntil;
    }

    public Long getSeatId() { return seatId; }
    public String getStatus() { return status; }
    public Instant getLockedUntil() { return lockedUntil; }
}
