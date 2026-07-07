package com.utma.tams.travel_agency_management_system_api.models.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CardRequestDTO {


    @NotBlank(message = "Owner name is mandatory.")
    @Size(max = 100, message = "Owner name must be up to 100 characters.")
    private String ownerName;

    @NotBlank(message = "Account number is mandatory.")
    @Pattern(
        regexp = "^[0-9]{13,19}$",
        message = "Account number must contain only numbers (between 13 and 19 digits)."
    )
    private String accountNumber;

    @NotNull(message = "Expiration date is mandatory.")
    private String expirationDate;

    @Pattern(
        regexp = "^[0-9]{3,4}$",
        message = "CVV must contain only numbers (3-4 digits)."
    )
    private String cvv;


    public CardRequestDTO(String ownerName, String accountNumber, String expirationDate, String cvv){
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public CardRequestDTO(){
        
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    
}

