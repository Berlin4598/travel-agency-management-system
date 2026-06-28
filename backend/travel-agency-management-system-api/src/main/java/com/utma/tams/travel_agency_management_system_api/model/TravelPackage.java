package com.utma.tams.travel_agency_management_system_api.model;

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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

// Travel Package POJO class
@Entity
@Table(name = "travel_packages")
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Long id;

    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "Package name must be up to 100 characters.")
    @NotBlank(message = "Package name is mandatory")
    private String packageName;

    @Column(length = 250)
    @Size(max = 250, message = "Description must be up to 250 characters.")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull(message = "Price is mandatory.")
    @PositiveOrZero(message = "Price must be zero or positive.")
    private BigDecimal price;

    @Column(nullable = false)
    @NotNull(message = "Duration days is mandatory.")
    @Min(value = 1, message = "Duration must be at least 1 day.")
    private Integer durationDays;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    @NotNull(message = "Destination is mandatory.")
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "transportation_id", nullable = false)
    @NotNull(message = "Transportation is mandatory.")
    private Transportation transportation;

    //Relationships

    @OneToMany(mappedBy = "travelPackage")
    private List<Reservation> reservations;

    

    public TravelPackage(){

    }

    public TravelPackage(String packageName, String description, BigDecimal price, Integer durationDays, Destination destination){
        this.packageName = packageName;
        this.description = description;
        this.price = price;
        this.durationDays = durationDays;
        this.destination = destination;
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

    @Override
    public String toString() {
        return "Package name: " + getPackageName() + " | package description: " + getDescription() + " | price: " + getPrice() + " | duration: " + getDurationDays() + " days | destination: " + getDestination();
    }
}
