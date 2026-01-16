package com.cinemaseatlock.cinemaseatlock.controller;

import com.cinemaseatlock.cinemaseatlock.dto.HealthResponseDto;
import com.cinemaseatlock.cinemaseatlock.mapper.HealthMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public HealthResponseDto health() {
        return HealthMapper.toDto("OK");
    }
}
