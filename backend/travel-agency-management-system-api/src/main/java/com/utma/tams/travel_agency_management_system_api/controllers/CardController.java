package com.utma.tams.travel_agency_management_system_api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utma.tams.travel_agency_management_system_api.models.dto.request.CardRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.CardResponseDTO;
import com.utma.tams.travel_agency_management_system_api.services.CardService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @GetMapping
    public ResponseEntity<List<CardResponseDTO>> getAllCards(){
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDTO> getCardById(@PathVariable Long id){
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @PostMapping
    public ResponseEntity<CardResponseDTO> createCard(@RequestBody @Valid CardRequestDTO requestDTO, @RequestParam (required = true) Long userId){
        return ResponseEntity.ok(cardService.createCard(requestDTO, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardResponseDTO> updateCard(@PathVariable Long id, @RequestBody @Valid CardRequestDTO requestDTO){
        return ResponseEntity.ok(cardService.updateCard(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CardResponseDTO> deleteCard(@PathVariable Long id){
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }


}
