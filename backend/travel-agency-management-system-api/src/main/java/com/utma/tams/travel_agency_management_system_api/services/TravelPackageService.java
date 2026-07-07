package com.utma.tams.travel_agency_management_system_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utma.tams.travel_agency_management_system_api.exception.ResourceNotFoundException;
import com.utma.tams.travel_agency_management_system_api.models.dto.request.TravelPackageRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.TravelPackageResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.entities.TravelPackage;
import com.utma.tams.travel_agency_management_system_api.repository.DestinationRepository;
import com.utma.tams.travel_agency_management_system_api.repository.TransportationRepository;
import com.utma.tams.travel_agency_management_system_api.repository.TravelPackageRepository;

@Service
public class TravelPackageService {

    private final TravelPackageRepository travelPackageRepository;
    private final DestinationRepository destinationRepository;
    private final TransportationRepository transportationRepository;

    public TravelPackageService(TravelPackageRepository travelPackageRepository, DestinationRepository destinationRepository, TransportationRepository transportationRepository){
        this.destinationRepository = destinationRepository;
        this.travelPackageRepository = travelPackageRepository;
        this.transportationRepository =  transportationRepository;
    }

    private TravelPackageResponseDTO toResponseDTO(TravelPackage travelPackage){
        return new TravelPackageResponseDTO(
            travelPackage.getId(),
            travelPackage.getPackageName(), 
            travelPackage.getDescription(), 
            travelPackage.getPrice(), 
            travelPackage.getDurationDays(), 
            travelPackage.getDestination().getId(), 
            travelPackage.getDestination().getCity(), 
            travelPackage.getDestination().getCountry(), 
            travelPackage.getTransportation().getId(), 
            travelPackage.getTransportation().getType(), 
            travelPackage.getTransportation().getCompany()
        );
    }

    private TravelPackage findById(Long id){
        return travelPackageRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Travel Package not found"));
    }

    public List<TravelPackageResponseDTO> getAllTravelPackages(){
        return travelPackageRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public TravelPackageResponseDTO getById(Long id){
        return toResponseDTO(findById(id));
    }

    public TravelPackageResponseDTO createTravelPackage(TravelPackageRequestDTO requestDTO){

        var destination = destinationRepository.findById(requestDTO.getDestinationId()).orElseThrow(()-> new ResourceNotFoundException("Destination not found"));
        var transportation = transportationRepository.findById(requestDTO.getTransportationId()).orElseThrow(()-> new ResourceNotFoundException("Transportation not found"));

        TravelPackage travelPackage = new TravelPackage(
            requestDTO.getPackageName(),
            requestDTO.getDescription(), 
            requestDTO.getPrice(), 
            requestDTO.getDurationDays(), 
            destination, transportation);

        travelPackageRepository.save(travelPackage);
        return toResponseDTO(travelPackage);
    }

    public TravelPackageResponseDTO updateTravelPackage(Long id, TravelPackageRequestDTO requestDTO){
        var travelPackage = findById(id);
        var destination = destinationRepository.findById(requestDTO.getDestinationId()).orElseThrow(()-> new ResourceNotFoundException("Destination not found"));
        var transportation = transportationRepository.findById(requestDTO.getTransportationId()).orElseThrow(()-> new ResourceNotFoundException("Transportation not found"));

        travelPackage.setPackageName(requestDTO.getPackageName());
        travelPackage.setDescription(requestDTO.getDescription());
        travelPackage.setDestination(destination);
        travelPackage.setDurationDays(requestDTO.getDurationDays());
        travelPackage.setPrice(requestDTO.getPrice());
        travelPackage.setTransportation(transportation);

        travelPackageRepository.save(travelPackage);

        return toResponseDTO(travelPackage);
    }

    public void deleteTravelPackage(Long id){
        travelPackageRepository.delete(findById(id));
    }

}
