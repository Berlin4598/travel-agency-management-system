package com.utma.tams.travel_agency_management_system_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.models.entities.Reservation;
import com.utma.tams.travel_agency_management_system_api.models.enums.ReservationStatus;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(Long id);
    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByTravelPackageId(Long packageId);
    List<Reservation> findByReservationStatus(ReservationStatus status); 
    List<Reservation> findByGuideId(Long guideId);
}
