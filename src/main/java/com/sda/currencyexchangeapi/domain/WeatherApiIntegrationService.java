package com.sda.currencyexchangeapi.domain;

import com.sda.currencyexchangeapi.model.Weather;
import org.springframework.stereotype.Service;

@Service
public class WeatherApiIntegrationService {

    public Weather getWeather() {
        // TODO Integracja z API do pogody
        return new Weather();
    }
}
