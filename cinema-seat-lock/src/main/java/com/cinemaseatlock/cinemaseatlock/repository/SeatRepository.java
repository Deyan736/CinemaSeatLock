package com.cinemaseatlock.cinemaseatlock.repository;

import com.cinemaseatlock.cinemaseatlock.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
