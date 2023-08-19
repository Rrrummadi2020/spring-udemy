package com.example.firstproject.service.impl;

import com.example.firstproject.DTO.WeatherDTO;
import com.example.firstproject.service.WeatherService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherServiceImpl implements WeatherService {
    public String getWeatherInformation() {
        RestTemplate restTemplate = new RestTemplate();
        System.setProperty("https.protocols", "TLSv1");
        String fooResourceUrl = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";
//        WeatherDTO response = restTemplate.getForObject(fooResourceUrl, WeatherDTO.class);
        return "null";
    }
}
