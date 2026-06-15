package com.utma.tams.travel_agency_management_system_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(Long id);
}
