package com.sda.currencyexchangeapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather_data")
public class Weather {

    @Id
    @GeneratedValue
    @Column(name = "weather_data_id")
    private Integer id;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "temperatur")
    private Double temperature;
    @Column(name = "atmospheric_pressure")
    private Long pressure;
    @Column(name = "humidity")
    private Long humidity;
    @Column(name = "wind_direction")
    private String windDirection;
    @Column(name = "wind_speed")
    private Double windSpeed;

    public Weather(String cityName, Double temperature, Long pressure, Long humidity, String windDirection, Double windSpeed) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }
}
