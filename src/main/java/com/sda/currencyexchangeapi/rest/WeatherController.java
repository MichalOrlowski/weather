package com.sda.currencyexchangeapi.rest;

import com.sda.currencyexchangeapi.model.WeatherDto;
import com.sda.currencyexchangeapi.domain.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather/{cityName}")
    public WeatherDto getWeather(@PathVariable(name = "cityName") final String cityName) {
        return weatherService.getAndProcessWeather(cityName);
    }

    @GetMapping("/api/db/counter")
    public long getDbRecordsCounter() {
        return weatherService.getDbCounter();
    }
}
