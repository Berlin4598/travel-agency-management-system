package com.utma.tams.travel_agency_management_system_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utma.tams.travel_agency_management_system_api.models.dto.response.FavoriteResponseDTO;
import com.utma.tams.travel_agency_management_system_api.services.FavoriteService;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public ResponseEntity<List<FavoriteResponseDTO>> getMyFavorites(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(favoriteService.getMyFavorites(userDetails.getUsername()));
    }

    @PostMapping("/{destinationId}")
    public ResponseEntity<List<FavoriteResponseDTO>> addFavorite(@AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long destinationId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(favoriteService.addFavorite(userDetails.getUsername(), destinationId));
    }

    @DeleteMapping("/{destinationId}")
    public ResponseEntity<List<FavoriteResponseDTO>> removeFavorite(@AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long destinationId) {
        return ResponseEntity.ok(favoriteService.removeFavorite(userDetails.getUsername(), destinationId));

    }
}
