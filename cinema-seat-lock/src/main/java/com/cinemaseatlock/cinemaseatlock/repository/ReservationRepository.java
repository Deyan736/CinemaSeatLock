package com.cinemaseatlock.cinemaseatlock.repository;

import com.cinemaseatlock.cinemaseatlock.entity.Reservation;
import com.cinemaseatlock.cinemaseatlock.entity.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Profesoru bitno: primer @Query
    @Query("""
        select count(r) > 0
        from Reservation r
        where r.seat.id = :seatId and r.status = :status
    """)
    boolean existsActiveReservation(Long seatId, ReservationStatus status);
}
