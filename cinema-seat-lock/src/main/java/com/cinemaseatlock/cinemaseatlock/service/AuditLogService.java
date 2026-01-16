package com.cinemaseatlock.cinemaseatlock.service;

import com.cinemaseatlock.cinemaseatlock.entity.AuditLog;
import com.cinemaseatlock.cinemaseatlock.repository.AuditLogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Transactional
    public void log(String action) {
        auditLogRepository.save(new AuditLog(action));
    }

    @Transactional(readOnly = true)
    public long count() {
        return auditLogRepository.countAllLogs();
    }
}
