package sg.edu.nus.iss.ssf_19l.service;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.ssf_19l.model.Weather;

@Service
public class WeatherService {
    RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "http://api.weatherapi.com/v1/current.json?key=8aa715933b9c4177a2614903240612&q=Singapore&aqi=no";

    public Weather getRawData() {
        RequestEntity<Void> request = RequestEntity.get(URL)
                .accept(MediaType.APPLICATION_JSON)
                .build();
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);

        JsonReader reader = Json.createReader(new StringReader(response.getBody()));
        JsonObject rawData = reader.readObject();
        JsonObject location = rawData.getJsonObject("location");
        JsonObject weather = rawData.getJsonObject("current");

        Weather w = new Weather(
            location.getString("country"),
            location.getString("name"), 
            LocalDate.parse(weather.getString("last_updated"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
            weather.getJsonObject("condition").getString("text"),
            weather.getJsonNumber("humidity").doubleValue(),
            weather.getJsonNumber("wind_kph").doubleValue(),
            weather.getJsonNumber("temp_c").doubleValue());
        return w;
    }

    public Optional<String> opt() {
        String newUrl = URL.replace("Singapore", "aoijdwiqjeoiwuheqo");
        RequestEntity<Void> request = RequestEntity.get(newUrl)
                .accept(MediaType.APPLICATION_JSON)
                .build();
                
        try {
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);
            System.out.println("No error");
            return Optional.ofNullable(response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.ofNullable(null);
        }

    }
}
