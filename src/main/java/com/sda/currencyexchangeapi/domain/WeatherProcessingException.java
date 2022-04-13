package com.sda.currencyexchangeapi.domain;

public class WeatherProcessingException extends RuntimeException {
    public WeatherProcessingException(final String message) {
        super(message);
    }
}