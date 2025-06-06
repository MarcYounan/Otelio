package com.otelio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.otelio.model.Reservation;
import com.otelio.repository.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        List<Reservation> conflicts = reservationRepository.findConflictingReservations(
            reservation.getRoom().getId(),
            reservation.getCheckInDate(),
            reservation.getCheckOutDate()
        );

        if (!conflicts.isEmpty()) {
            throw new IllegalStateException("This room is already reserved for the selected dates.");
        }
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
