package com.utma.tams.travel_agency_management_system_api.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utma.tams.travel_agency_management_system_api.exception.ResourceNotFoundException;
import com.utma.tams.travel_agency_management_system_api.models.dto.request.ReservationRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.ReservationResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.entities.Guide;
import com.utma.tams.travel_agency_management_system_api.models.entities.Reservation;
import com.utma.tams.travel_agency_management_system_api.models.entities.TravelPackage;
import com.utma.tams.travel_agency_management_system_api.models.entities.User;
import com.utma.tams.travel_agency_management_system_api.models.enums.ReservationStatus;
import com.utma.tams.travel_agency_management_system_api.repository.GuideRepository;
import com.utma.tams.travel_agency_management_system_api.repository.ReservationRepository;
import com.utma.tams.travel_agency_management_system_api.repository.TravelPackageRepository;
import com.utma.tams.travel_agency_management_system_api.repository.UserRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final GuideRepository guideRepository;
    private final TravelPackageRepository travelPackageRepository;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, GuideRepository guideRepository, TravelPackageRepository travelPackageRepository){
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.guideRepository = guideRepository;
        this.travelPackageRepository = travelPackageRepository;
    }

    private ReservationResponseDTO toResponseDTO(Reservation reservation){
        return new ReservationResponseDTO(
            reservation.getId(), 
            reservation.getReservationDate(), 
            reservation.getNumberOfPeople(), 
            reservation.getReservationStatus(), 
            reservation.getCustomer().getId(), 
            reservation.getCustomer().getFirstName().concat(" ").concat(reservation.getCustomer().getLastName()), 
            reservation.getTravelPackage().getId(), 
            reservation.getTravelPackage().getPackageName(), 
            reservation.getGuide().getId(),
            reservation.getGuide().getFirstName().concat(" ").concat(reservation.getGuide().getLastName())
        );
    }

    private Reservation findById(Long id){
        return reservationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Reservation not found"));
    }

    public List<ReservationResponseDTO> getAllReservations(){
        return reservationRepository.findAll()
            .stream()
            .map(this::toResponseDTO)
            .collect(Collectors.toList());
    }

    public ReservationResponseDTO getReservationById(Long id){
        return toResponseDTO(findById(id));
    }

    public ReservationResponseDTO createReservation(ReservationRequestDTO requestDTO, Long id){
        LocalDate date = LocalDate.now();
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        Guide guide = guideRepository.findById(requestDTO.getGuideId()).orElseThrow(()-> new ResourceNotFoundException("Guide not found"));
        TravelPackage travelPackage = travelPackageRepository.findById(requestDTO.getTravelPackageId()).orElseThrow(()-> new ResourceNotFoundException("TravelPackage not found"));

        guide.setAvailable(false);
        guideRepository.save(guide);

        Reservation reservation = new Reservation(date, requestDTO.getNumberOfPeople(), ReservationStatus.PENDING,user, travelPackage, guide);

        reservationRepository.save(reservation);
        return toResponseDTO(reservation);
    }


    public ReservationResponseDTO updateReservation(Long id, ReservationRequestDTO requestDTO){
        var reservation = findById(id);

        Guide assignedGuide = guideRepository.findById(reservation.getGuide().getId()).orElseThrow(()-> new ResourceNotFoundException("Guide not found"));

        Guide guide = guideRepository.findById(requestDTO.getGuideId()).orElseThrow(()-> new ResourceNotFoundException("Guide not found"));

        TravelPackage travelPackage = travelPackageRepository.findById(requestDTO.getTravelPackageId()).orElseThrow(()-> new ResourceNotFoundException("TravelPackage not found"));

        if (!assignedGuide.getId().equals(guide.getId())){
            assignedGuide.setAvailable(true);
            guideRepository.save(assignedGuide);
            guide.setAvailable(false);
            guideRepository.save(guide);
        }

        reservation.setNumberOfPeople(requestDTO.getNumberOfPeople());
        reservation.setGuide(guide);
        reservation.setTravelPackage(travelPackage);
        
        reservationRepository.save(reservation);
        return toResponseDTO(reservation);
    }

    public void deleteReservation(Long id){
        reservationRepository.delete(findById(id));
    }

    public ReservationResponseDTO confirmReservation(Long id){
        var reservation = findById(id);
        reservation.setReservationStatus(ReservationStatus.CONFIRMED);
        reservationRepository.save(reservation);

        return toResponseDTO(reservation);
    }

    public ReservationResponseDTO cancelReservation(Long id){
        var reservation = findById(id);
        reservation.setReservationStatus(ReservationStatus.CANCELED);
        reservationRepository.save(reservation);

        reservation.getGuide().setAvailable(true);
        guideRepository.save(reservation.getGuide());
        
        return toResponseDTO(reservation);
    }

    
    public List<ReservationResponseDTO> getUserReservations(Long id){
        if (reservationRepository.findByUserId(id).isEmpty()) {
            throw new ResourceNotFoundException("No reservations");
        }
        return reservationRepository.findByUserId(id).stream()
        .map(this::toResponseDTO).collect(Collectors.toList());
    }



}
