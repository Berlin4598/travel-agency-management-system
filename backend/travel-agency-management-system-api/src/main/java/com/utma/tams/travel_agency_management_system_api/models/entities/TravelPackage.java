package com.utma.tams.travel_agency_management_system_api.models.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Travel Package POJO class
@Entity
@Table(name = "travel_packages")
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Long id;

    @Column(nullable = false, length = 100, name = "package_name")
    private String packageName;

    @Column(length = 250, name = "description")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2, name = "price")
    private BigDecimal price;

    @Column(nullable = false, name = "duration_days")
    private Integer durationDays;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "transportation_id", nullable = false)
    private Transportation transportation;

    //Relationships

    @OneToMany(mappedBy = "travelPackage")
    private List<Reservation> reservations;

    
    public TravelPackage(){

    }

    public TravelPackage(String packageName, String description, BigDecimal price, Integer durationDays, Destination destination, Transportation transportation){
        this.packageName = packageName;
        this.description = description;
        this.price = price;
        this.durationDays = durationDays;
        this.destination = destination;
        this.transportation = transportation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    @Override
    public String toString() {
        return "Package name: " + getPackageName() + " | package description: " + getDescription() + " | price: " + getPrice() + " | duration: " + getDurationDays() + " days | destination: " + getDestination();
    }
}
