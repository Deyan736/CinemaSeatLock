package com.cinemaseatlock.cinemaseatlock.controller;

import com.cinemaseatlock.cinemaseatlock.dto.*;
import com.cinemaseatlock.cinemaseatlock.mapper.ReservationMapper;
import com.cinemaseatlock.cinemaseatlock.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ReservationResponseDto create(
            @Valid @RequestBody ReservationCreateRequestDto req
    ) {
        return ReservationMapper.toDto(
                reservationService.createReservation(req.getSeatId(), req.getEmail())
        );
    }
}