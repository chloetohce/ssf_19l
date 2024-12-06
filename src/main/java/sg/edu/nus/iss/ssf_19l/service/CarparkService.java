package sg.edu.nus.iss.ssf_19l.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.edu.nus.iss.ssf_19l.model.Carpark;

@Service
public class CarparkService {
    RestTemplate restTemplate = new RestTemplate();

    public List<Carpark> getCarparkRates() {
        RequestEntity<Void> entity = RequestEntity.get("localhost:8080/api/carpark/rates")
                .build();
        ResponseEntity<List<Carpark>> responseCarpark = restTemplate.exchange(entity, new ParameterizedTypeReference<List<Carpark>>(){});
        List<Carpark> carparkRates = responseCarpark.getBody();

        return carparkRates;
    }
}
