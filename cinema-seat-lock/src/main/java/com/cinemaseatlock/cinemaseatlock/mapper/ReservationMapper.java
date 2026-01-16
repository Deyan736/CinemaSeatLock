package com.cinemaseatlock.cinemaseatlock.mapper;

import com.cinemaseatlock.cinemaseatlock.dto.ReservationResponseDto;
import com.cinemaseatlock.cinemaseatlock.entity.Reservation;

public class ReservationMapper {

    private ReservationMapper() {}

    public static ReservationResponseDto toDto(Reservation r) {
        return new ReservationResponseDto(
                r.getId(),
                r.getSeat().getId(),
                r.getStatus().name(),
                r.getCreatedAt()
        );
    }
}