package com.utma.tams.travel_agency_management_system_api.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.models.entities.Card;

public interface CardRepository extends JpaRepository<Card,Long> {
    List<Card> findByUserId(Long userId);
}
