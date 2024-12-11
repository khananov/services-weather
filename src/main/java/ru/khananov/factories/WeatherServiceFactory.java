package ru.khananov.factories;

import ru.khananov.services.WeatherService;
import ru.khananov.services.impl.WeatherServiceImpl;

public class WeatherServiceFactory {
  private WeatherServiceFactory() {
  }

  public static WeatherService getWeatherService() {
    return new WeatherServiceImpl();
  }
}
