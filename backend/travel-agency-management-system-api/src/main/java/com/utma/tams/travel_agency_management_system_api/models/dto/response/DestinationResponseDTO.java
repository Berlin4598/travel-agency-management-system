package com.utma.tams.travel_agency_management_system_api.models.dto.response;

public class DestinationResponseDTO {

    private Long id;
    private String city;
    private String country;
    private String description;
    private String imageUrl;

    public DestinationResponseDTO(Long id, String city, String country, String description, String imageUrl){
        this.id = id;
        this.city = city;
        this.country = country;
        this.description = description;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }


    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 
    

    
}
