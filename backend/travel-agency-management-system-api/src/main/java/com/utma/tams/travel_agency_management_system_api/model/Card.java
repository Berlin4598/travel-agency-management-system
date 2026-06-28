package com.utma.tams.travel_agency_management_system_api.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// Card POJO Class
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "Owner name must be up to 100 characters.")
    @NotBlank(message = "Owner name is mandatory.")
    private String ownerName;

    @Column(nullable = false, length = 20)
    @Pattern(
        regexp = "^[0-9]{13,19}$",
        message = "Account number must contain only numbers (between 13 and 19 digits)."
    )
    @NotBlank(message = "Account number is mandatory.")
    private String accountNumber;

    @Column(nullable = false)
    @NotNull(message = "Expiration date is mandatory.")
    private LocalDate expirationDate;

    @Column(nullable = false, length = 4)
    @Pattern(
        regexp = "^[0-9]{3,4}$",
        message = "CVV must contain only numbers (3-4 digits)."
    )
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User is mandatory.")
    private User user;



    public Card(){

    }

    public Card(String ownerName, String accountNumber, LocalDate expirationDate, String cvv){
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    
}
