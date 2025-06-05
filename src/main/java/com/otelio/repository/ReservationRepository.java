package com.otelio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.otelio.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
}
