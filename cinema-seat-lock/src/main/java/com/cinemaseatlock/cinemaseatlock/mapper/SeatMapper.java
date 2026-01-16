package com.cinemaseatlock.cinemaseatlock.mapper;

import com.cinemaseatlock.cinemaseatlock.dto.SeatDto;
import com.cinemaseatlock.cinemaseatlock.dto.SeatLockResponseDto;
import com.cinemaseatlock.cinemaseatlock.entity.Seat;

public class SeatMapper {

    private SeatMapper() {}

    public static SeatLockResponseDto toLockDto(Seat seat) {
        return new SeatLockResponseDto(
                seat.getId(),
                seat.getStatus().name(),
                seat.getLockedUntil()
        );
    }

    public static SeatDto toDto(Seat seat) {
        return new SeatDto(
                seat.getId(),
                seat.getSeatNumber(),
                seat.getStatus().name(),
                seat.getLockedUntil()
        );
    }
}
