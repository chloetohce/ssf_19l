package sg.edu.nus.iss.ssf_19l.model;

import java.time.LocalDate;

public class Weather {
    private String country;
    private String city;
    private LocalDate updated;
    private String weather;
    private double humidity;
    private double wind_kph;
    private double temp;
    
    public Weather(String country, String city, LocalDate updated, String weather, double humidity, double wind_kph,
            double temp) {
        this.country = country;
        this.city = city;
        this.updated = updated;
        this.weather = weather;
        this.humidity = humidity;
        this.wind_kph = wind_kph;
        this.temp = temp;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    
}
