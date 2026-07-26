package com.utma.tams.travel_agency_management_system_api.models.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequestDTO {

    @Size(max = 100, message = "Email must be up to 100 characters long.")
    @Email(message = "Invalid Email.")  
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(
        String email, String password) {
        this.email = email;
        this.password = password;
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


    

}
