package com.utma.tams.travel_agency_management_system_api.models.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


// Transportation POJO Class
@Entity
@Table(name = "transportation")
public class Transportation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transportation_id")
    private Long id;

    @Column(nullable = false, length = 30, name = "type")
    private String type;

    @Column(length = 50, name = "company")
    private String company;

    @Column(name = "capacity", length = 5)
    private Integer capacity;

    //Relationships
    @OneToMany(mappedBy = "transportation")
    private List<TravelPackage> travelPackages;
    

    


    public Transportation(){

    }

    public Transportation(String type, String company, Integer capacity){
        this.type = type;
        this.company = company;
        this.capacity = capacity;
        
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

    @Override
    public String toString() {
        return "ID: " + getId() + " | Type: " + getType() + " | Company: " + getCompany() + " | Capacity: " + getCapacity();
    }
}
