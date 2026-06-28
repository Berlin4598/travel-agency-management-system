package com.utma.tams.travel_agency_management_system_api.models.dto.response;

public class GuideResponseDTO {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Boolean available;
    
    public GuideResponseDTO() {
    }

    public GuideResponseDTO(String firstName, String lastName, String phone, String email, Boolean available) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.available = available;
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

    

    
}
