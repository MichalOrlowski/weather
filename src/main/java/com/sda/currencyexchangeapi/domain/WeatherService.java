package com.sda.currencyexchangeapi.domain;

import com.sda.currencyexchangeapi.model.Weather;
import com.sda.currencyexchangeapi.model.WeatherDto;
import com.sda.currencyexchangeapi.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private WeatherApiIntegrationService weatherApiIntegrationService;
    private WeatherRepository weatherRepository;
    private WeatherMapper weatherMapper;

    @Autowired
    public WeatherService(WeatherApiIntegrationService weatherApiIntegrationService, WeatherRepository weatherRepository, WeatherMapper weatherMapper) {
        this.weatherApiIntegrationService = weatherApiIntegrationService;
        this.weatherRepository = weatherRepository;
        this.weatherMapper = weatherMapper;
    }

    public WeatherDto getAndProcessWeather(String cityName) {
        // Get weather from external service
        Weather weather = weatherApiIntegrationService.getWeather(cityName);
        // Save weather to database
        weatherRepository.save(weather);
        // Map weather to weatherDto
        WeatherDto weatherDto = weatherMapper.map(weather);
        // Return weatherDto to user
        return weatherDto;
    }
}
