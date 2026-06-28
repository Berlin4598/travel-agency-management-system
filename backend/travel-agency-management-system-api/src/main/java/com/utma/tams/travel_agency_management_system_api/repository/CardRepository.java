package com.utma.tams.travel_agency_management_system_api.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utma.tams.travel_agency_management_system_api.model.Card;

public interface CardRepository extends JpaRepository<Card,Long> {
    Optional<Card> findByUserId(Long userId);
}
