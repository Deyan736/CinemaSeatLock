package com.cinemaseatlock.cinemaseatlock.controller;

import com.cinemaseatlock.cinemaseatlock.dto.SeatDto;
import com.cinemaseatlock.cinemaseatlock.dto.SeatLockResponseDto;
import com.cinemaseatlock.cinemaseatlock.mapper.SeatMapper;
import com.cinemaseatlock.cinemaseatlock.repository.SeatRepository;
import com.cinemaseatlock.cinemaseatlock.service.SeatLockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatLockService seatLockService;
    private final SeatRepository seatRepository;

    public SeatController(SeatLockService seatLockService, SeatRepository seatRepository) {
        this.seatLockService = seatLockService;
        this.seatRepository = seatRepository;
    }

    @PostMapping("/{seatId}/lock")
    public SeatLockResponseDto lock(@PathVariable Long seatId) {
        return SeatMapper.toLockDto(seatLockService.lockSeat(seatId));
    }

    @GetMapping
    public List<SeatDto> getSeats() {
        return seatRepository.findAll()
                .stream()
                .map(SeatMapper::toDto)
                .toList();
    }
}
