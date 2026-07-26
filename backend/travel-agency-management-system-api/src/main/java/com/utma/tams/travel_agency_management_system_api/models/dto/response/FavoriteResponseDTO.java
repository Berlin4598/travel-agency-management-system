package com.utma.tams.travel_agency_management_system_api.models.dto.response;

public class FavoriteResponseDTO {
    private Long destinationId;
    private String city;
    private String country;
    private String description;

    public FavoriteResponseDTO(Long destinationId, String city, String country, String description) {
        this.destinationId = destinationId;
        this.city = city;
        this.country = country;
        this.description = description;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
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
