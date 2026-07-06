package com.utma.tams.travel_agency_management_system_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utma.tams.travel_agency_management_system_api.models.dto.request.TransportationRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.TransportationResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.entities.Transportation;
import com.utma.tams.travel_agency_management_system_api.repository.TransportationRepository;

@Service
public class TransportationService {

    private final TransportationRepository transportationRepository;

    public TransportationService(TransportationRepository transportationRepository){
        this.transportationRepository = transportationRepository;
    }

    private TransportationResponseDTO toResponseDTO(Transportation transportation){
        return new TransportationResponseDTO(transportation.getId(),transportation.getType(), transportation.getCompany(), transportation.getCapacity());
    }

    private Transportation findById(Long id){
        return transportationRepository.findById(id).orElseThrow(()-> new RuntimeException("Transportation not found"));
    }

    public List<TransportationResponseDTO> getAllTransportations(){
        return transportationRepository.findAll().stream()
            .map(this :: toResponseDTO)
            .collect(Collectors.toList());
    }

    public TransportationResponseDTO getTransportationById(Long id){
        return toResponseDTO(findById(id));
    }

    public TransportationResponseDTO createTransportation(TransportationRequestDTO requestDTO){
        Transportation transportation = new Transportation(
            requestDTO.getType(), 
            requestDTO.getCompany(), 
            requestDTO.getCapacity()
        );

        transportationRepository.save(transportation);
        return toResponseDTO(transportation);
    }

    public TransportationResponseDTO updateTransportation(Long id, TransportationRequestDTO requestDTO){
        var transportation = findById(id);
        transportation.setType(requestDTO.getType());
        transportation.setCompany(requestDTO.getCompany());
        transportation.setCapacity(requestDTO.getCapacity());

        transportationRepository.save(transportation);
        return toResponseDTO(transportation);
    }

    public void deleteTransportation(Long id){
        transportationRepository.deleteById(id);
    }
    

}
