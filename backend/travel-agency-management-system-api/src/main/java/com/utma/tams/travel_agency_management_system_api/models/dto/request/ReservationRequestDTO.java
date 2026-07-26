package com.utma.tams.travel_agency_management_system_api.models.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ReservationRequestDTO {


    @NotNull(message = "Number of people is mandatory.")
    @Min(value = 1, message = "Number of people must be at least 1.")
    private Integer numberOfPeople;

    @NotNull(message = "Travel package is mandatory.")
    private Long travelPackageId;


    public ReservationRequestDTO(Integer numberOfPeople, Long packageId, Long guideId){
        this.numberOfPeople = numberOfPeople;
        this.travelPackageId = packageId;
    }

    public ReservationRequestDTO() {
    }


    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Long getTravelPackageId() {
        return travelPackageId;
    }

    public void setTravelPackageId(Long travelPackageId) {
        this.travelPackageId = travelPackageId;
    }

}
