package com.utma.tams.travel_agency_management_system_api.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DestinationRequestDTO {

    @Size(max = 50, message = "City must be up to 50 characters long.")
    @NotBlank(message = "City is mandatory.")
    private String city;

    @Size(max = 50, message = "Country must be up to 50 characters long.")
    @NotBlank(message = "Country is mandatory.")
    private String country;

    @Size(max = 200, message = "Description must be up to 200 characters long.")
    private String description;


    public DestinationRequestDTO(String city, String country, String description){
        this.city = city;
        this.country = country;
        this.description = description;
    }

    public DestinationRequestDTO(){

    }

    

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
