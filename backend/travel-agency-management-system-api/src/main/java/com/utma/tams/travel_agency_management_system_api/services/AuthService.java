package com.utma.tams.travel_agency_management_system_api.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.utma.tams.travel_agency_management_system_api.config.JwtUtil;
import com.utma.tams.travel_agency_management_system_api.config.UserDetailsServiceImpl;
import com.utma.tams.travel_agency_management_system_api.models.dto.request.LoginRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.request.UserRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.LoginResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.UserResponseDTO;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AuthService(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService,
            JwtUtil jwtUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    public LoginResponseDTO login (LoginRequestDTO requestDTO){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(requestDTO.getEmail(), requestDTO.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(requestDTO.getEmail());
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        String token = jwtUtil.generateToken(requestDTO.getEmail(), role);

        return new LoginResponseDTO(token, requestDTO.getEmail(), role);
    }

    public UserResponseDTO register (UserRequestDTO requestDTO){
        return userService.createUser(requestDTO);
    }
}
