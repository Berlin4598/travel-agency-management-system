package com.utma.tams.travel_agency_management_system_api.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Card POJO Class
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    @Column(nullable = false, length = 100, name = "owner_name")
    private String ownerName;

    @Column(nullable = false, length = 20, name = "account_number")
    private String accountNumber;

    @Column(nullable = false, name = "expiration_date")
    private LocalDate expirationDate;

    @Column(nullable = false, length = 4, name = "cvv")
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Card(){

    }

    public Card(String ownerName, String accountNumber, LocalDate expirationDate, String cvv, User user){
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

    
}
