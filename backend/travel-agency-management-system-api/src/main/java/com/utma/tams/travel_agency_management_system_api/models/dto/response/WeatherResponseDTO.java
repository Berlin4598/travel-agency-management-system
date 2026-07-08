package com.utma.tams.travel_agency_management_system_api.models.dto.response;

import java.util.List;

public class WeatherResponseDTO {
    private Long destinationId;
    private String city;
    private String country;
    private List<DayWeatherDTO> forecast;

    public WeatherResponseDTO(Long destinationId, String city, String country, List<DayWeatherDTO> forecast) {
        this.destinationId = destinationId;
        this.city = city;
        this.country = country;
        this.forecast = forecast;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
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

    public List<DayWeatherDTO> getForecast() {
        return forecast;
    }

    public void setForecast(List<DayWeatherDTO> forecast) {
        this.forecast = forecast;
    }

    
}
