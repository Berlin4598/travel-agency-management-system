package com.utma.tams.travel_agency_management_system_api.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
    @Pattern(regexp = "^[0-9]{13,19}",message = "Account number must contain only numbers(between 13 and 19 digits)")
    @NotBlank(message = "Account number is mandatory.")
    private String accountNumber;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Pattern(regexp = "^[0-9]{3,4}$", message = "CVV must contain only 3-4 digits.")
    @Column(name = "cvv", nullable = false, length = 4)
    private Integer cvv;

    @ManyToMany(mappedBy = "cards")
    private Set<User> users = new HashSet<>();


    public Card(){

    }

    public Card(String ownerName, String accountNumber, LocalDate expirationDate, Integer cvv){
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

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    
}
