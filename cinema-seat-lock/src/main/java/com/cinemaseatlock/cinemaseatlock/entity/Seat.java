package com.cinemaseatlock.cinemaseatlock.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    @ManyToOne(optional = false)
    private Event event;

    protected Seat() {}

    public Seat(String seatNumber, Event event) {
        this.seatNumber = seatNumber;
        this.event = event;
    }

    public Long getId() { return id; }
    public String getSeatNumber() { return seatNumber; }
    public Event getEvent() { return event; }
}
