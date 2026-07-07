package com.utma.tams.travel_agency_management_system_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utma.tams.travel_agency_management_system_api.exception.ResourceNotFoundException;
import com.utma.tams.travel_agency_management_system_api.models.dto.request.UserRequestDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.UserResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.entities.User;
import com.utma.tams.travel_agency_management_system_api.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    private UserResponseDTO toResponseDTO(User user){
        return new UserResponseDTO(user.getId(),user.getFirstName(),user.getLastName(),user.getPhone(),user.getEmail(),user.getAddress());
    }

    private User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public List<UserResponseDTO> getAllUsers(){
        return userRepository.findAll()
        .stream().map(this :: toResponseDTO)
        .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(Long id){
        return toResponseDTO(findById(id));
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO){
        User user = new User(
            userRequestDTO.getFirstName(),
                userRequestDTO.getLastName(),
                userRequestDTO.getPhone(),
                userRequestDTO.getEmail(),
            userRequestDTO.getPassword(),
            userRequestDTO.getAddress()
        );
        if (userRequestDTO.getEmail().contains("@travelagency.com")) {
            user.setRole("ADMIN");
        }

        userRepository.save(user);

        return toResponseDTO(user);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO){
        var user = findById(id);
        
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setAddress(userRequestDTO.getAddress());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setPassword(userRequestDTO.getPassword());

        if (userRequestDTO.getEmail().contains("@travelagency.com") && user.getRole().equals("USER")) {
            user.setRole("ADMIN");
        } else{
            user.setRole("USER");
        }

        userRepository.save(user);
        return toResponseDTO(user);
    }

    public void deleteUser(Long id){
        userRepository.delete(findById(id));
    }

    
}
