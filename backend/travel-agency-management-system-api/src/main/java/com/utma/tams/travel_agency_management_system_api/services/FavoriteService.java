package com.utma.tams.travel_agency_management_system_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utma.tams.travel_agency_management_system_api.exception.ResourceNotFoundException;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.FavoriteResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.entities.User;
import com.utma.tams.travel_agency_management_system_api.repository.DestinationRepository;
import com.utma.tams.travel_agency_management_system_api.repository.UserRepository;

@Service
public class FavoriteService {

    private final UserRepository userRepository;
    private final DestinationRepository destinationRepository;

    public FavoriteService(UserRepository userRepository, DestinationRepository destinationRepository) {
        this.userRepository = userRepository;
        this.destinationRepository = destinationRepository;
    }

    private User findUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found"));
    }

    public List<FavoriteResponseDTO> getMyFavorites(String email){
        var user = findUserByEmail(email);
        return user.getFavDestinations().stream()
        .map(d -> new FavoriteResponseDTO(d.getId(), d.getCity(), d.getCountry(),d.getDescription()))
        .collect(Collectors.toList());
    }

    public List<FavoriteResponseDTO> addFavorite (String email, Long destinationId){
        var user = findUserByEmail(email);
        var destination = destinationRepository.findById(destinationId).orElseThrow(()-> new ResourceNotFoundException("Destination not found"));

        if (user.getFavDestinations().contains(destination)) {
            throw new RuntimeException("Destination already in favorites");
        }

        user.getFavDestinations().add(destination);
        userRepository.save(user);
        return getMyFavorites(email);
    }

    public List<FavoriteResponseDTO> removeFavorite(String email, Long destinationId){
        var user = findUserByEmail(email);
        var destination = destinationRepository.findById(destinationId).orElseThrow(()-> new ResourceNotFoundException("Destination not found"));

        user.getFavDestinations().remove(destination);
        userRepository.save(user);
        return getMyFavorites(email);
    }
    
}
