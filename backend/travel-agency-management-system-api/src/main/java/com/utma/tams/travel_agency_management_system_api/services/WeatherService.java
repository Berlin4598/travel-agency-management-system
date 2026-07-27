package com.utma.tams.travel_agency_management_system_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.utma.tams.travel_agency_management_system_api.exception.ResourceNotFoundException;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.DayWeatherDTO;
import com.utma.tams.travel_agency_management_system_api.models.dto.response.WeatherResponseDTO;
import com.utma.tams.travel_agency_management_system_api.models.entities.Destination;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponseDTO getWeatherByDestination(Destination destination) {
        String geoUrl = "https://geocoding-api.open-meteo.com/v1/search?name="
                + destination.getCity() + "&count=1&language=es&format=json";

        Map<String, Object> geoResponse = restTemplate.getForObject(geoUrl, Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) geoResponse.get("results");

        if (results == null || results.isEmpty()) {
            throw new ResourceNotFoundException("Could not find coordinates for city: " + destination.getCity());
        }

        Double latitude = (Double) results.get(0).get("latitude");
        Double longitude = (Double) results.get(0).get("longitude");

        String weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude
                + "&longitude=" + longitude
                + "&daily=temperature_2m_max,temperature_2m_min,weathercode"
                + "&forecast_days=7&timezone=auto";

        Map<String, Object> weatherResponse = restTemplate.getForObject(weatherUrl, Map.class);
        Map<String, Object> daily = (Map<String, Object>) weatherResponse.get("daily");

        List<String> dates = (List<String>) daily.get("time");
        List<Double> maxTemps = (List<Double>) daily.get("temperature_2m_max");
        List<Double> minTemps = (List<Double>) daily.get("temperature_2m_min");
        List<Integer> weatherCodes = (List<Integer>) daily.get("weathercode");

        List<DayWeatherDTO> forecast = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            int code = weatherCodes.get(i);
            forecast.add(new DayWeatherDTO(
                    dates.get(i),
                    maxTemps.get(i),
                    minTemps.get(i),
                    getCondition(code),
                    getIcon(code)));
        }

        return new WeatherResponseDTO(
                destination.getId(),
                destination.getCity(),
                destination.getCountry(),
                forecast);
    }

    private String getCondition(int code) {
        if (code == 0)
            return "Sunny";
        if (code <= 3)
            return "Partly Cloudy";
        if (code <= 48)
            return "Cloudy";
        if (code <= 67)
            return "Rainy";
        if (code <= 77)
            return "Snowy";
        return "Stormy";
    }

    private String getIcon(int code) {
    String baseUrl = "https://cdn.meteocons.com/3.0.0-next.10/svg/flat/";
    if (code == 0) return baseUrl + "clear-day.svg";
    if (code <= 3) return baseUrl + "partly-cloudy-day.svg";
    if (code <= 48) return baseUrl + "cloudy.svg";
    if (code <= 67) return baseUrl + "rain.svg";
    if (code <= 77) return baseUrl + "snow.svg";
    return baseUrl + "thunderstorms.svg";
}
}