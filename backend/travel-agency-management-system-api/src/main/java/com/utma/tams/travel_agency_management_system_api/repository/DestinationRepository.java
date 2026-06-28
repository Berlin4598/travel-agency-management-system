package com.utma.tams.travel_agency_management_system_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.models.entities.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long>{
    Optional<Destination> findById(Long id);
    List<Destination> findByCountry(String country);
    List<Destination> findByCity(String city);
    
}
