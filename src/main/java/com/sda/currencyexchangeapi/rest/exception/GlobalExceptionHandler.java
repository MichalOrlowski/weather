package com.sda.currencyexchangeapi.rest.exception;

import com.sda.currencyexchangeapi.domain.WeatherProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WeatherProcessingException.class)
    public ErrorResponse handleWeatherProcessingException(final WeatherProcessingException exception) {
        log.debug("Exception occurred");
        return new ErrorResponse(exception.getMessage());
    }
}
