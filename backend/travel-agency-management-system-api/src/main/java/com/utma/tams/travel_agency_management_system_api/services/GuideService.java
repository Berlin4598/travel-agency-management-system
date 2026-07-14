package com.utma.tams.travel_agency_management_system_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utma.tams.travel_agency_management_system_api.exception.ResourceNotFoundException;
import com.utma.tams.travel_agency_management_system_api.models.dto.request.GuideRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.GuideResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.entities.Guide;
import com.utma.tams.travel_agency_management_system_api.repository.GuideRepository;

@Service
public class GuideService {

    private final GuideRepository guideRepository;


    public GuideService(GuideRepository guideRepository){
        this.guideRepository = guideRepository;
    }

    private GuideResponseDTO toResponseDTO(Guide guide){
        return new GuideResponseDTO(guide.getFirstName(), guide.getLastName(), guide.getPhone(), guide.getEmail(), guide.isAvailable());
    }

    private Guide findById(Long id){
        return guideRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Guide not found"));
    }

    public List<GuideResponseDTO> getAllGuides(){
        return guideRepository.findAll()
        .stream()
        .map(this :: toResponseDTO)
        .collect(Collectors.toList());
    }

    public GuideResponseDTO getGuideById(Long id){
        return toResponseDTO(findById(id));
    }

    public GuideResponseDTO createGuide(GuideRequestDTO requestDTO){
        Guide guide = new Guide(
        requestDTO.getFirstName(),
        requestDTO.getLastName(),
        requestDTO.getPhone(), 
        requestDTO.getEmail()
        );

        guideRepository.save(guide);
        return toResponseDTO(guide);
    }

    public GuideResponseDTO updateGuide(Long id, GuideRequestDTO requestDTO){
        var guide = findById(id);

        guide.setFirstName(requestDTO.getFirstName());
        guide.setLastName(requestDTO.getLastName());
        guide.setPhone(requestDTO.getPhone());
        guide.setEmail(requestDTO.getEmail());

        guideRepository.save(guide);
        return toResponseDTO(guide);
    }

    public void deleteGuide(Long id){
        guideRepository.delete(findById(id));
    }



    public List<GuideResponseDTO> getAvailableGuides(){
        return guideRepository.findByAvailable(true).stream()
        .map(this::toResponseDTO)
        .collect(Collectors.toList());
        
    }



}
