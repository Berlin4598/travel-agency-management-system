package com.utma.tams.travel_agency_management_system_api.models.dto;

import java.time.LocalDate;

public class CardResponseDTO {
    
    private Long id;
    private String ownerName;
    private String accountNumber;
    private LocalDate expirationDate;
    private Long userId;
    
    public CardResponseDTO(Long id, String ownerName, String accountNumber, LocalDate expirationDate, Long userId){
        this.id = id;
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.expirationDate = expirationDate;
        this.userId = userId;
    }

    public CardResponseDTO(){

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
