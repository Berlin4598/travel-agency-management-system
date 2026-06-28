package com.utma.tams.travel_agency_management_system_api.models.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

    @Size(max = 50, message = "First name must be up to 50 characters long.")
    @NotBlank(message = "First name is mandatory.")
    private String firstName;

    @Size(max = 50, message = "Last name must be up to 50 characters long.")
    @NotBlank(message = "Last name is mandatory.")
    private String lastName;

    @Size(max = 15, message = "Phone number must be between 10 and 15 characters.")
    @Pattern(
        regexp = "^[0-9]{10,15}$",
        message = "Account number must contain only numbers (between 10 and 15 digits)."
    )
    private String phone;

    @Email(message = "Invalid Email.")
    @Size(max = 100, message = "Email must be up to 100 characters.")
    private String email;

    private String password;

    @Size(max = 150, message = "Address must be up to 150 characters.")
    private String address;

    public UserRequestDTO(String firstName, String lastName, String phone, String email, String password, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public UserRequestDTO(){

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

}
