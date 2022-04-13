package com.sda.currencyexchangeapi.domain;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sda.currencyexchangeapi.model.Weather;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class WeatherApiIntegrationService {

    public Weather getWeather(String cityName) {
        try {
            return getCurrentDataFromOpenWeatherMap(cityName);
        } catch (IOException e) {
            throw new WeatherProcessingException("Cannot get weather data.");
        }
    }

    public Weather getCurrentDataFromOpenWeatherMap(String cityName) throws IOException {
        return getWeatherData(cityName, getJsonObject(URLGenerator(cityName)), "main", "wind", "temp",
                "speed");
    }

    private Weather getWeatherData(String cityName, JsonObject jsonObject, String main, String main2, String temp,
                                   String wSpeed) {
        double temperature = jsonObject.get(main).getAsJsonObject().get(temp).getAsDouble();
        long pressure = jsonObject.get(main).getAsJsonObject().get("pressure").getAsLong();
        long humidity = jsonObject.get(main).getAsJsonObject().get("humidity").getAsLong();
        double windSpeed = jsonObject.get(main2).getAsJsonObject().get(wSpeed).getAsDouble();
        String windDirection = "n/a";

        return new Weather(cityName, temperature, pressure, humidity, windDirection, windSpeed);
    }


    private JsonObject getJsonObject(String sURL) throws IOException {
        URLConnection request = getUrlConnection(sURL);
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        return root.getAsJsonObject();
    }

    private URLConnection getUrlConnection(String sURL) throws IOException {
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();
        return request;
    }

    private String URLGenerator(String cityName) {
        return "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&&units=metric&appid=2e17c40d72b22d8b8202de7c3e7c7358";
    }
}
