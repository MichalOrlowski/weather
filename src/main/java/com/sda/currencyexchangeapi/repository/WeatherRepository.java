package com.sda.currencyexchangeapi.repository;

import com.sda.currencyexchangeapi.model.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Integer> {
}
