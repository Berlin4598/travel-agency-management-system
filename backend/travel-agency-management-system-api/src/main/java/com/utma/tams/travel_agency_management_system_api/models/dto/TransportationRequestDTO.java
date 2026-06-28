package com.utma.tams.travel_agency_management_system_api.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TransportationRequestDTO {

    @Size(max = 30, message = "Type must be up to 30 characters long.")
    @NotBlank(message = "Type is mandatory.")
    private String type;

    @Size(max = 50, message = "Company must be up to 50 characters.")
    private String company;

    @Min(value = 1, message = "Capacity must be at least 1.")
    private Integer capacity;


    public TransportationRequestDTO(String type, String company, Integer capacity){
        this.type = type;
        this.company = company;
        this.capacity = capacity;
    }

    public TransportationRequestDTO(){

    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    

}
