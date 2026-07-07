package com.utma.tams.travel_agency_management_system_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utma.tams.travel_agency_management_system_api.exception.ResourceNotFoundException;
import com.utma.tams.travel_agency_management_system_api.models.dto.request.DestinationRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.DestinationResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.entities.Destination;
import com.utma.tams.travel_agency_management_system_api.repository.DestinationRepository;

@Service
public class DestinationService {
    
    //Dependency injection
    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository){
        this.destinationRepository = destinationRepository;
    }

     private DestinationResponseDTO toResponseDTO(Destination destination){
        return new DestinationResponseDTO(destination.getCity(),destination.getCountry(),destination.getDescription());
    }

    private Destination findById(Long id){
        return destinationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Destination not found"));
    }

    // CRUD methods
    public DestinationResponseDTO createDestination (DestinationRequestDTO requestDTO){
        Destination destination = new Destination(
            requestDTO.getCity(),
            requestDTO.getCountry(),
            requestDTO.getDescription()
        );
        destinationRepository.save(destination);
        return toResponseDTO(destination);
    }

    public List<DestinationResponseDTO> getAllDestinations(){
        return destinationRepository.findAll().stream().map(this :: toResponseDTO).collect(Collectors.toList());
    }

    public DestinationResponseDTO getDestinationById(Long id){
        return toResponseDTO(findById(id));
    }

    public DestinationResponseDTO updateDestination (Long id, DestinationRequestDTO requestDTO){
        Destination destination = findById(id);

        destination.setCity(requestDTO.getCity());
        destination.setCountry(requestDTO.getCountry());
        destination.setDescription(requestDTO.getDescription());

        destinationRepository.save(destination);
    
        return toResponseDTO(destination);
    }

    public void deleteDestination (Long id){
        destinationRepository.delete(findById(id));
    }

}
