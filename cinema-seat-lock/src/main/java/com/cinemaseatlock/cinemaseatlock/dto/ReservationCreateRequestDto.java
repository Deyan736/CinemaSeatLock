package com.cinemaseatlock.cinemaseatlock.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class ReservationCreateRequestDto {

    @NotNull
    private Long seatId;

    @Email
    @NotNull
    private String email;

    public Long getSeatId() { return seatId; }
    public String getEmail() { return email; }

    public void setSeatId(Long seatId) { this.seatId = seatId; }
    public void setEmail(String email) { this.email = email; }
}
