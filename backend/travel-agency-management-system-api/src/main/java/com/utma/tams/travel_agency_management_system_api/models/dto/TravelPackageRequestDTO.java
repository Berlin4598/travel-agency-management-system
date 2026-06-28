package com.utma.tams.travel_agency_management_system_api.models.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class TravelPackageRequestDTO {

    @Size(max = 100, message = "Package name must be up to 100 characters.")
    @NotBlank(message = "Package name is mandatory")
    private String packageName;

    @Size(max = 250, message = "Description must be up to 250 characters.")
    private String description;

    @NotNull(message = "Price is mandatory.")
    @PositiveOrZero(message = "Price must be zero or positive.")
    private BigDecimal price;

    @NotNull(message = "Duration days is mandatory.")
    @Min(value = 1, message = "Duration must be at least 1 day.")
    private Integer durationDays;

    @NotNull(message = "Destination is mandatory.")
    private Long destinationId;

    @NotNull(message = "Transportation is mandatory.")
    private Long transportationId;

    public TravelPackageRequestDTO(String packageName, String description, BigDecimal price, Integer durationDays, Long destinationId, Long transportationId){
        this.packageName = packageName;
        this.description = description;
        this.price = price;
        this.durationDays = durationDays;
        this.destinationId = destinationId;
        this.transportationId = transportationId;
    }

    public TravelPackageRequestDTO(){
        
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

    public Long getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(Long transportationId) {
        this.transportationId = transportationId;
    }

    

}
