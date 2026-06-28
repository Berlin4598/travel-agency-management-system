package com.utma.tams.travel_agency_management_system_api.models.dto;

import java.time.LocalDate;

import com.utma.tams.travel_agency_management_system_api.models.enums.ReservationStatus;

public class ReservationResponseDTO {

    private Long id;
    private LocalDate reservationDate;
    private Integer numberOfPeople;
    private ReservationStatus reservationStatus;
    private Long userId;
    private String userFullName;
    private Long travelPackageId;
    private String travelPackageName;
    private Long guideId;
    private String guideFullName;

    public ReservationResponseDTO(Long id, LocalDate reservationDate, Integer numberOfPeople, ReservationStatus reservationStatus, Long userId, String userFullName, Long travelPackageId, String travelPackageName, Long guideId, String guideFullName) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.numberOfPeople = numberOfPeople;
        this.reservationStatus = reservationStatus;
        this.userId = userId;
        this.userFullName = userFullName;
        this.travelPackageId = travelPackageId;
        this.travelPackageName = travelPackageName;
        this.guideId = guideId;
        this.guideFullName = guideFullName;
    }

    public ReservationResponseDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public Long getTravelPackageId() {
        return travelPackageId;
    }

    public void setTravelPackageId(Long travelPackageId) {
        this.travelPackageId = travelPackageId;
    }

    public String getTravelPackageName() {
        return travelPackageName;
    }

    public void setTravelPackageName(String travelPackageName) {
        this.travelPackageName = travelPackageName;
    }

    public Long getGuideId() {
        return guideId;
    }

    public void setGuideId(Long guideId) {
        this.guideId = guideId;
    }

    public String getGuideFullName() {
        return guideFullName;
    }

    public void setGuideFullName(String guideFullName) {
        this.guideFullName = guideFullName;
    }

    
}
