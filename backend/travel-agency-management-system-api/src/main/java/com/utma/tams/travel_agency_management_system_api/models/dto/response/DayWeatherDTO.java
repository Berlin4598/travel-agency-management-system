package com.utma.tams.travel_agency_management_system_api.models.dto.response;

public class DayWeatherDTO {
    private String date;
    private Double maxTemp;
    private Double minTemp;
    private String condition;  // "Sunny", "Cloudy", "Rainy"
    private String icon;       // emoji o URL

    public DayWeatherDTO(String date, Double maxTemp, Double minTemp, String condition, String icon) {
        this.date = date;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.condition = condition;
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    

}
