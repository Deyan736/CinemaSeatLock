package com.cinemaseatlock.cinemaseatlock.dto;

import java.time.Instant;

public class ReservationResponseDto {

    private Long reservationId;
    private Long seatId;
    private String status;
    private Instant createdAt;

    public ReservationResponseDto(
            Long reservationId,
            Long seatId,
            String status,
            Instant createdAt
    ) {
        this.reservationId = reservationId;
        this.seatId = seatId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getReservationId() { return reservationId; }
    public Long getSeatId() { return seatId; }
    public String getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }
}
