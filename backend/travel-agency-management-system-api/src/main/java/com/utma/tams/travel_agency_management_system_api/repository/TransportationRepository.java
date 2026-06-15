package com.utma.tams.travel_agency_management_system_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.model.Transportation;

public interface TransportationRepository extends JpaRepository<Transportation, Long> {
    Optional<Transportation> findById(Long id);
}
