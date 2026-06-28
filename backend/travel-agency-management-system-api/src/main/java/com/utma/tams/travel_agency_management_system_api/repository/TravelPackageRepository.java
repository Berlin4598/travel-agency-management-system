package com.utma.tams.travel_agency_management_system_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.models.entities.TravelPackage;

public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
    Optional<TravelPackage> findById(Long id);
    List<TravelPackage> findByDestinationId(Long destinationId);
    List<TravelPackage> findByTransportationId(Long transportationId);


}
