package com.utma.tams.travel_agency_management_system_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.model.Guide;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    Optional<Guide> findById(Long id);
    List<Guide> findByAvailable(Boolean available);
}
