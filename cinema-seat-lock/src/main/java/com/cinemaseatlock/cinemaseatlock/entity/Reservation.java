package com.cinemaseatlock.cinemaseatlock.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
        name = "reservations",
        uniqueConstraints = @UniqueConstraint(columnNames = "seat_id")
)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Column(nullable = false)
    private String userEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    protected Reservation() {}

    public Reservation(Seat seat, String userEmail) {
        this.seat = seat;
        this.userEmail = userEmail;
        this.status = ReservationStatus.CONFIRMED;
        this.createdAt = Instant.now();
    }

    // getters
    public Long getId() { return id; }
    public Seat getSeat() { return seat; }
    public String getUserEmail() { return userEmail; }
    public ReservationStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }

    // domain behavior
    public void cancel() {
        this.status = ReservationStatus.CANCELLED;
    }
}
