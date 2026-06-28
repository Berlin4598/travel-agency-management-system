package com.utma.tams.travel_agency_management_system_api.models.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ReservationRequestDTO {

    @NotNull(message = "Reservation date is mandatory.")
    private LocalDate reservationDate;

    @NotNull(message = "Number of people is mandatory.")
    @Min(value = 1, message = "Number of people must be at least 1.")
    private Integer numberOfPeople;

    @NotNull(message = "Travel package is mandatory.")
    private Long travelPackageId;

    @NotNull(message = "Guide is mandatory.")
    private Long guideId;

    public ReservationRequestDTO(LocalDate reservationDate, Integer numberOfPeople, Long packageId, Long guideId){
        this.reservationDate = reservationDate;
        this.numberOfPeople = numberOfPeople;
        this.travelPackageId = packageId;
        this.guideId = guideId;
    }

    public ReservationRequestDTO() {
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
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

    public Long getGuideId() {
        return guideId;
    }

    public void setGuideId(Long guideId) {
        this.guideId = guideId;
    }

    

}
