package com.utma.tams.travel_agency_management_system_api.models.dto.response;

import java.math.BigDecimal;

public class TravelPackageResponseDTO {

    private Long id;
    private String packageName;
    private String description;
    private BigDecimal price;
    private Integer durationDays;
    private Long destinationId;
    private String destinationCity;
    private String destinationCountry;
    private Long transportationId;
    private String transportationType;
    private String transportationCompany;

    public TravelPackageResponseDTO(Long id, String packageName, String description, BigDecimal price, Integer durationDays, Long destinationId, String destinationCity, String destinationCountry, Long transportationId, String transportationType, String transportationCompany) {
        this.id = id;
        this.packageName = packageName;
        this.description = description;
        this.price = price;
        this.durationDays = durationDays;
        this.destinationId = destinationId;
        this.destinationCity = destinationCity;
        this.destinationCountry = destinationCountry;
        this.transportationId = transportationId;
        this.transportationType = transportationType;
        this.transportationCompany = transportationCompany;
    }

    public TravelPackageResponseDTO(){

    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPackageName() {
        return packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getDurationDays() {
        return durationDays;
    }
    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }
    public Long getDestinationId() {
        return destinationId;
    }
    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }
    public String getDestinationCity() {
        return destinationCity;
    }
    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
    public String getDestinationCountry() {
        return destinationCountry;
    }
    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }
    public Long getTransportationId() {
        return transportationId;
    }
    public void setTransportationId(Long transportationId) {
        this.transportationId = transportationId;
    }
    public String getTransportationType() {
        return transportationType;
    }
    public void setTransportationType(String transportationType) {
        this.transportationType = transportationType;
    }
    public String getTransportationCompany() {
        return transportationCompany;
    }
    public void setTransportationCompany(String transportationCompany) {
        this.transportationCompany = transportationCompany;
    }

    
}
