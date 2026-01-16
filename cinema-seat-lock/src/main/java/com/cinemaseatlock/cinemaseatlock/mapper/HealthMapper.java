package com.cinemaseatlock.cinemaseatlock.mapper;

import com.cinemaseatlock.cinemaseatlock.dto.HealthResponseDto;

public class HealthMapper {
    private HealthMapper() {}

    public static HealthResponseDto toDto(String status) {
        return new HealthResponseDto(status);
    }
}
