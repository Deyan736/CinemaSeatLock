package com.cinemaseatlock.cinemaseatlock.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "audit_log")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private Instant createdAt;

    protected AuditLog() {
        // JPA
    }

    public AuditLog(String action) {
        this.action = action;
        this.createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public String getAction() { return action; }
    public Instant getCreatedAt() { return createdAt; }

    public void setAction(String action) { this.action = action; }
}
