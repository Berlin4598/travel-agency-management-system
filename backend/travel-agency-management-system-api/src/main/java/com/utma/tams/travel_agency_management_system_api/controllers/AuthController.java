package com.utma.tams.travel_agency_management_system_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utma.tams.travel_agency_management_system_api.models.dto.request.LoginRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.request.UserRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.LoginResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.UserResponseDTO;
import com.utma.tams.travel_agency_management_system_api.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (@RequestBody @Valid LoginRequestDTO requestDTO){
        return ResponseEntity.ok(authService.login(requestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserRequestDTO requestDTO){
        return ResponseEntity.ok(authService.register(requestDTO));
    }
}
