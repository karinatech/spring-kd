package com.cybertek.serviceImpl;

import com.cybertek.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {


    RestTemplate restTemplate;
    ObjectMapper objectMapper;

    public WeatherServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    String URI="http://api.weatherstack.com/current?access_key=02a009b8e3922c395677a1e85406aca6&query=";

    public ResponseEntity<String> getWeather(String city) {
        ResponseEntity<String> weather = restTemplate.getForEntity(URI + city, String.class, city);
        return weather;

    }
    @Override
    public String getWeatherAsAString(ResponseEntity<String> weatherEntity) {
        try{
            JsonNode root = objectMapper.readTree(weatherEntity.getBody());
            return root.path("current").path("temperature").asText();
        }catch (JsonProcessingException e){
            throw new RuntimeException("Error parsing JSON",e);
        }

    }




}
