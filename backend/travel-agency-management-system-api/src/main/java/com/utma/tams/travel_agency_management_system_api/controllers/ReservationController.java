package com.utma.tams.travel_agency_management_system_api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utma.tams.travel_agency_management_system_api.models.dto.request.ReservationRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.ReservationResponseDTO;
import com.utma.tams.travel_agency_management_system_api.services.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservations(){
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> getReservationById(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody @Valid ReservationRequestDTO requestDTO,@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.createReservation(requestDTO, userDetails.getUsername()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> updateReservation(@RequestBody @Valid ReservationRequestDTO requestDTO,@PathVariable Long id){
        return ResponseEntity.ok(reservationService.updateReservation(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    } 

    @PatchMapping("/{id}/confirm")
    public ResponseEntity<ReservationResponseDTO> confirmReservation(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.confirmReservation(id));
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<ReservationResponseDTO> cancelReservation(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.cancelReservation(id));
    }

    @GetMapping("/user")
    public ResponseEntity<List<ReservationResponseDTO>> getUserReservations(@RequestParam Long id){
        return ResponseEntity.ok(reservationService.getUserReservations(id));
    }

    @GetMapping("/my")
    public ResponseEntity<List<ReservationResponseDTO>> getMyReservations(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(reservationService.getMyReservations(userDetails.getUsername()));
    }
    
}
