package sg.edu.nus.iss.ssf_19l.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.ssf_19l.model.Weather;
import sg.edu.nus.iss.ssf_19l.service.WeatherService;



@RestController
@RequestMapping("weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("")
    public Weather rawData() {
        return weatherService.getRawData();
    }
    
    @GetMapping("/opt")
    public String opt() {
        Optional<String> w = weatherService.opt();
        String next = w.map(str -> str.replace("current", "data"))
                .orElse("Inside was a null");
        return next;
    }
    
}
