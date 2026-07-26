package com.utma.tams.travel_agency_management_system_api.models.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Destination POJO Class
@Entity
@Table(name = "destinations")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destination_id")
    private Long id;

    @Column(nullable = false, length = 50, name = "city")
    private String city;

    @Column(nullable = false, length = 50, name = "country")
    private String country;

    @Column(length = 200, nullable = true, name = "description")
    private String description;

    //Relationships

    @OneToMany(mappedBy = "destination")
    private List<TravelPackage> travelPackages;

        @ManyToMany(mappedBy = "favDestinations")
        private List<User> userFavs;


    public Destination(){

    }

    public Destination(String city, String country, String description){
        this.city = city;
        this.country = country;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "DestinationID: " + getId() + " | City: " + getCity() + " | Country: " + getCountry() + " | Description: " + getDescription();
    }
    
}
