package com.utma.tams.travel_agency_management_system_api.models.dto;

public class DestinationResponseDTO {

    private String city;
    private String country;
    private String description;

    public DestinationResponseDTO(String city, String country, String description){
        this.city = city;
        this.country = country;
        this.description = description;
    }

    public DestinationResponseDTO(){

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
