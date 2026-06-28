package com.utma.tams.travel_agency_management_system_api.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Guide POJO Class
@Entity
@Table(name = "guides")
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guide_id")
    private Long id;

    @Column(nullable = false, length = 50)
    @Size(max = 50, message = "First name must be up to 50 characters long.")
    @NotBlank(message = "First name is mandatory.")
    private String firstName;

    @Column(nullable = false, length = 50)
    @Size(max = 50, message = "Last name must be up to 50 characters long.")
    @NotBlank(message = "Last name is mandatory.")
    private String lastName;

    @Column(length = 15)
    @Size(max = 15, message = "Phone number must be up to 50 characters long.")
    private String phone;

    @Column(length = 100)
    @Size(max = 100, message = "Email must be up to 100 characters long.")
    @Email(message = "Invalid Email.")
    private String email;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean available = true;
    
    //Relationships
    
    @OneToMany(mappedBy = "guide")
    private List<Reservation> reservations;

    public Guide() {

    }

    public Guide(String firstName, String lastName, String phone, String email, Boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "GuideID: " + getId() + " | Name: " + getFirstName() + " " + getLastName() + " | Available: " + isAvailable();
    }

}
