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

import com.utma.tams.travel_agency_management_system_api.models.dto.request.TransportationRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.TransportationResponseDTO;
import com.utma.tams.travel_agency_management_system_api.services.TransportationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/transportations")
public class TransportationController {

    private final TransportationService transportationService;

    public TransportationController(TransportationService transportationService){
        this.transportationService = transportationService;
    }

    @GetMapping
    public ResponseEntity<List<TransportationResponseDTO>> getAllTransportations(){
        return ResponseEntity.ok(transportationService.getAllTransportations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransportationResponseDTO> getTransportationById(@PathVariable Long id){
        return ResponseEntity.ok(transportationService.getTransportationById(id));
    }

    @PostMapping
    public ResponseEntity<TransportationResponseDTO> createTransportation(@RequestBody @Valid TransportationRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(transportationService.createTransportation(requestDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<TransportationResponseDTO> updateTransportation(@PathVariable Long id, @RequestBody @Valid TransportationRequestDTO requestDTO){
        return ResponseEntity.ok(transportationService.updateTransportation(id, requestDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTransportation(@PathVariable Long id){
        transportationService.deleteTransportation(id);
        return ResponseEntity.noContent().build();
    }
}
