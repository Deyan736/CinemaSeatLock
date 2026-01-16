package com.cinemaseatlock.cinemaseatlock.controller;

import com.cinemaseatlock.cinemaseatlock.dto.AuditCountDto;
import com.cinemaseatlock.cinemaseatlock.mapper.AuditMapper;
import com.cinemaseatlock.cinemaseatlock.service.AuditLogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audit")
public class AuditController {

    private final AuditLogService auditLogService;

    public AuditController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public void log(@RequestParam String action) {
        auditLogService.log(action);
    }

    @GetMapping("/count")
    public AuditCountDto count() {
        return AuditMapper.toCountDto(auditLogService.count());
    }
}
