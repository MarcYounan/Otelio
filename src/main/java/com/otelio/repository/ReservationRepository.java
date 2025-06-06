package com.otelio.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.otelio.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
    @Query("""
        SELECT r FROM Reservation r
        WHERE r.room.id = :roomId
        AND r.checkInDate < :checkOutDate
        AND r.checkOutDate > :checkInDate
    """)
    List<Reservation> findConflictingReservations(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);
}
