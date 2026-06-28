package com.utma.tams.travel_agency_management_system_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(Long id);
    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByTravelPackageId(Long packageId);
    List<Reservation> findByReservationStatus(String status); 
    List<Reservation> findByGuideId(Long guideId);
}
