package com.utma.tams.travel_agency_management_system_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utma.tams.travel_agency_management_system_api.models.dto.request.DestinationRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.DestinationResponseDTO;
import com.utma.tams.travel_agency_management_system_api.services.DestinationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/destinations")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService){
        this.destinationService = destinationService;
    }

    @GetMapping
    public ResponseEntity<List<DestinationResponseDTO>> getAllDestinations(){
        return ResponseEntity.ok(destinationService.getAllDestinations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationResponseDTO> getDestinationById(@PathVariable Long id){
        return ResponseEntity.ok(destinationService.getDestinationById(id));
    }

    @PostMapping
    public ResponseEntity<DestinationResponseDTO> createDestination(@RequestBody @Valid DestinationRequestDTO destinationRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(destinationService.createDestination(destinationRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinationResponseDTO> updateDestination(@PathVariable Long id, @RequestBody @Valid DestinationRequestDTO destinationRequestDTO){
        return ResponseEntity.ok(destinationService.updateDestination(id, destinationRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return ResponseEntity.noContent().build();
    }



}
