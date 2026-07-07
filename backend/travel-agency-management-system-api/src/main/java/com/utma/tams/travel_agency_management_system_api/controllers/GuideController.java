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

import com.utma.tams.travel_agency_management_system_api.models.dto.request.GuideRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.GuideResponseDTO;
import com.utma.tams.travel_agency_management_system_api.services.GuideService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/guides")
public class GuideController {

    private final GuideService guideService;

    public GuideController (GuideService guideService){
        this.guideService = guideService;
    }

    @GetMapping
    public ResponseEntity<List<GuideResponseDTO>> getAllGuides(){
        return ResponseEntity.ok(guideService.getAllGuides());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideResponseDTO> getGuideById(@PathVariable Long id){
        return ResponseEntity.ok(guideService.getGuideById(id));
    }

    @PostMapping
    public ResponseEntity<GuideResponseDTO> createGuide(@RequestBody @Valid GuideRequestDTO requestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(guideService.createGuide(requestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuideResponseDTO> updateGuide(@PathVariable Long id, @RequestBody @Valid GuideRequestDTO requestDTO){
        return ResponseEntity.ok(guideService.updateGuide(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuide(@PathVariable Long id){
        guideService.deleteGuide(id);
        return ResponseEntity.noContent().build();
    }


}
