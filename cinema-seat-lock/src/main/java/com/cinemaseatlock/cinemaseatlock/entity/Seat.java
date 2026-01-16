package com.cinemaseatlock.cinemaseatlock.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatStatus status = SeatStatus.FREE;

    private Instant lockedUntil;

    @Version
    private Long version;

    protected Seat() {}

    public Seat(String seatNumber, Event event) {
        this.seatNumber = seatNumber;
        this.event = event;
    }

    public Long getId() { return id; }
    public String getSeatNumber() { return seatNumber; }
    public Event getEvent() { return event; }

    public SeatStatus getStatus() { return status; }
    public Instant getLockedUntil() { return lockedUntil; }

    public void lockUntil(Instant until) {
        this.status = SeatStatus.LOCKED;
        this.lockedUntil = until;
    }

    public void markSold() {
        this.status = SeatStatus.SOLD;
        this.lockedUntil = null;
    }

    public void unlockIfExpired(Instant now) {
        if (status == SeatStatus.LOCKED && this.lockedUntil != null && this.lockedUntil.isBefore(now)) {
            status = SeatStatus.FREE;
            lockedUntil = null;
        }
    }


}

