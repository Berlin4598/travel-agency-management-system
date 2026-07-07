package com.utma.tams.travel_agency_management_system_api.services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utma.tams.travel_agency_management_system_api.exception.ResourceNotFoundException;
import com.utma.tams.travel_agency_management_system_api.models.dto.request.CardRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.CardResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.entities.Card;
import com.utma.tams.travel_agency_management_system_api.models.entities.User;
import com.utma.tams.travel_agency_management_system_api.repository.CardRepository;
import com.utma.tams.travel_agency_management_system_api.repository.UserRepository;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public CardService(CardRepository cardRepository, UserRepository userRepository){
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
    }

    private CardResponseDTO toResponseDTO(Card card){
        return new CardResponseDTO(card.getId(), card.getOwnerName(), card.getAccountNumber(), card.getExpirationDate(), card.getUser().getId());
    }

    private Card findById(Long id){
        return cardRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Card not found"));
    }

    public List<CardResponseDTO> getAllCards(){
        return cardRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public CardResponseDTO getCardById(Long id){
        return toResponseDTO(findById(id));
    }

    public CardResponseDTO createCard(CardRequestDTO requestDTO, Long userId){
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found"));

        LocalDate expirationDate = YearMonth.parse(requestDTO.getExpirationDate()).atDay(1);

        Card card = new Card(requestDTO.getOwnerName(), requestDTO.getAccountNumber(), expirationDate, requestDTO.getCvv(), user);

        cardRepository.save(card);
        return toResponseDTO(card);
    }

    public CardResponseDTO updateCard(Long cardId, CardRequestDTO requestDTO){
        Card card = findById(cardId);
        
        card.setOwnerName(requestDTO.getOwnerName());
        card.setAccountNumber(requestDTO.getAccountNumber());
        card.setExpirationDate(YearMonth.parse(requestDTO.getExpirationDate()).atDay(1));
        card.setCvv(requestDTO.getCvv());

        cardRepository.save(card);
        return toResponseDTO(card);
    }

    public void deleteCard(Long cardId){
        cardRepository.delete(findById(cardId));
    }


}
