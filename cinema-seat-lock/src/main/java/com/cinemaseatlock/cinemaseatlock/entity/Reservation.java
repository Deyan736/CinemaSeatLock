package com.cinemaseatlock.cinemaseatlock.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "reservations",
        uniqueConstraints = @UniqueConstraint(columnNames = "seat_id"))
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Seat seat;

    private String userEmail;

    private Instant createdAt;

    protected Reservation() {}

    public Reservation(Seat seat, String userEmail) {
        this.seat = seat;
        this.userEmail = userEmail;
        this.createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public Seat getSeat() { return seat; }
    public String getUserEmail() { return userEmail; }
}
