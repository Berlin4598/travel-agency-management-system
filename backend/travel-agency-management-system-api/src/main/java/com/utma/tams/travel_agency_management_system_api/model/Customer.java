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

// Customer POJO Class
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(nullable = false, length = 50)
    @Size(max = 50, message = "First name must be up to 50 characters long.")
    @NotBlank(message = "First name is mandatory.")
    private String firstName;

    @Column(nullable = false, length = 50)
    @Size(max = 50, message = "Last name must be up to 50 characters long.")
    @NotBlank(message = "Last name is mandatory.")
    private String lastName;

    @Column(nullable = true, length = 15)
    @Size(max = 15, message = "Phone number must be between 10 and 15 characters.")
    private String phone;

    @Column(nullable = true, length = 100)
    @Email(message = "Invalid Email.")
    @Size(max = 100, message = "Email must be up to 100 characters.")
    private String email;

    @Column(nullable = true, length = 150)
    @Size(max = 150, message = "Address must be up to 150 characters.")
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;

    public Customer(){

    }

    public Customer(String firstname, String lastname, String phone, String email, String address){
        this.firstName = firstname;
        this.lastName = lastname;
        this.phone = phone;
        this.email = email;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " | First Name: " + getFirstName() + " | Last Name: " + getLastName() + " | Phone: " + getPhone() + " | Email: " + getEmail() + " | Address: " + getAddress();
    }

}
