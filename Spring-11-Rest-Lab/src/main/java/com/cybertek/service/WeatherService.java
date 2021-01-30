package com.cybertek.service;

import org.springframework.http.ResponseEntity;

public interface WeatherService {
    ResponseEntity<String> getWeather(String city);
    String getWeatherAsAString(ResponseEntity<String> weatherEntity);

}
