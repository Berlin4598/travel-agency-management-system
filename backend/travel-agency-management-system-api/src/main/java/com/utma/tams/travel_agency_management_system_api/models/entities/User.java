package com.utma.tams.travel_agency_management_system_api.models.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// User POJO Class
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 50, name = "first_name")
    private String firstName;

    @Column(nullable = false, length = 50, name = "last_name")
    private String lastName;

    @Column(nullable = true, length = 15, name = "phone")
    private String phone;

    @Column(nullable = true, length = 100, name = "email")
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = true, length = 150, name = "address")
    private String address;

    @Column(name = "role")
    private String role = "USER";

    //Relationships

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Card> cards = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "favorites",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "destination_id")   
    )
    private List<Destination> favDestinations;

    

    public User(){

    }

    public User(String firstname, String lastname, String phone, String email, String password, String address){
        this.firstName = firstname;
        this.lastName = lastname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = "USER";
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


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + " | First Name: " + getFirstName() + " | Last Name: " + getLastName() + " | Phone: " + getPhone() + " | Email: " + getEmail() + " | Address: " + getAddress() + " | ROLE: " + getRole();
    }

}
