package com.cinemaseatlock.cinemaseatlock.repository;

import com.cinemaseatlock.cinemaseatlock.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    @Query("select count(a) from AuditLog a")
    long countAllLogs();
}
