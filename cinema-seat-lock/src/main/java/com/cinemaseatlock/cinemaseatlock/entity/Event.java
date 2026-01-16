package com.cinemaseatlock.cinemaseatlock.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.time.Instant;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats = new ArrayList<>();

    protected Event() {}

    public Event(String name) {
        this.name = name;
        this.startsAt = Instant.now();
    }
    public Instant getStartsAt() { return startsAt; }

    // helper da održava obe strane relacije
    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Seat> getSeats() { return seats; }
    @Column(name = "starts_at", nullable = false)
    private Instant startsAt;

}
