package com.utma.tams.travel_agency_management_system_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.models.entities.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long>{
    List<Destination> findByCountry(String country);
    List<Destination> findByCity(String city);
    
}
