package com.sda.currencyexchangeapi.rest;

import com.sda.currencyexchangeapi.model.WeatherDto;
import com.sda.currencyexchangeapi.domain.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    //TODO dostosuj po integracji z API
    @GetMapping("/api/weather/10-10-2020/???")
    public WeatherDto getWeather() {
        return weatherService.getAndProcessWeather();
    }
}
