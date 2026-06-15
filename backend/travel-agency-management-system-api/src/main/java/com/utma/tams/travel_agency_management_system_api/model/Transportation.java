package com.utma.tams.travel_agency_management_system_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// Transportation POJO Class
@Entity
@Table(name = "transportation")
public class Transportation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transportation_id")
    private Long id;

    @Column(nullable = false, length = 30)
    @Size(max = 30, message = "Type must be up to 30 characters long.")
    @NotBlank(message = "Type is mandatory.")
    private String type;

    @Column(length = 50)
    @Size(max = 50, message = "Company must be up to 50 characters.")
    private String company;

    @Min(value = 1, message = "Capacity must be at least 1.")
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    @NotNull(message = "Travel Package is mandatory.")
    private TravelPackage travelPackage;


    public Transportation(){

    }

    public Transportation(String type, String company, Integer capacity, TravelPackage travelPackage){
        this.type = type;
        this.company = company;
        this.capacity = capacity;
        this.travelPackage = travelPackage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public TravelPackage getTravelPackage() {
        return travelPackage;
    }

    public void setTravelPackage(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " | Type: " + getType() + " | Company: " + getCompany() + " | Capacity: " + getCapacity();
    }
}
