package com.utma.tams.travel_agency_management_system_api.models.dto;

public class TransportationResponseDTO {

    private Long id;
    private String type;
    private String company;
    private Integer capacity;

    public TransportationResponseDTO(Long id, String type, String company, Integer capacity) {
        this.id = id;
        this.type = type;
        this.company = company;
        this.capacity = capacity;
    }

    public TransportationResponseDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
