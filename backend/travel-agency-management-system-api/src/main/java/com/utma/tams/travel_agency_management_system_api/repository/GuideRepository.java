package com.utma.tams.travel_agency_management_system_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.models.entities.Guide;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    List<Guide> findByAvailable(Boolean available);
}
