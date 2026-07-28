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

import com.utma.tams.travel_agency_management_system_api.models.dto.request.TravelPackageRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.TravelPackageResponseDTO;
import com.utma.tams.travel_agency_management_system_api.services.TravelPackageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/travelpackages")
public class TravelPackageController {

    private final TravelPackageService travelPackageService;

    public TravelPackageController(TravelPackageService travelPackageService){
        this.travelPackageService = travelPackageService;
    }

    @GetMapping
    public ResponseEntity<List<TravelPackageResponseDTO>> getAllTravelPackages(){
        return ResponseEntity.ok(travelPackageService.getAllTravelPackages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelPackageResponseDTO> getTravelPackageById(@PathVariable Long id){
        return ResponseEntity.ok(travelPackageService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TravelPackageResponseDTO> createTravelPackage(@RequestBody @Valid TravelPackageRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(travelPackageService.createTravelPackage(requestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TravelPackageResponseDTO> updateTravelPackage(@RequestBody @Valid TravelPackageRequestDTO requestDTO, @PathVariable Long id){
        return ResponseEntity.ok(travelPackageService.updateTravelPackage(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TravelPackageResponseDTO> deleteTravelPackage(@PathVariable Long id){
        travelPackageService.deleteTravelPackage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/destination/{id}")
    public ResponseEntity<List<TravelPackageResponseDTO>> getByDestination(@PathVariable Long id){
        return ResponseEntity.ok(travelPackageService.getByDestinationId(id));
    }
}
