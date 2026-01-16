package com.cinemaseatlock.cinemaseatlock.mapper;

import com.cinemaseatlock.cinemaseatlock.dto.AuditCountDto;

public class AuditMapper {
    private AuditMapper() {}

    public static AuditCountDto toCountDto(long count) {
        return new AuditCountDto(count);
    }
}
