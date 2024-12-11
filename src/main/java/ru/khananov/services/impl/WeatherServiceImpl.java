package ru.khananov.services.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.khananov.services.WeatherService;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;

public class WeatherServiceImpl implements WeatherService {
  private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
  private static final String YANDEX_WEATHER_URL = "https://yandex.ru/pogoda";

  @Override
  public String getWeather(String latitude, String longitude) {
    String url = YANDEX_WEATHER_URL + "?lat=" + latitude + "&lon=" + longitude;
    try {
      Document document = Jsoup.connect(url).get();

      String temperature = parseTemperature(document);
      String condition = parseCondition(document);

      return "Температура: " + temperature + ", Состояние: " + condition;
    } catch (IOException e) {
      logger.severe(e.getMessage());
      return "Ошибка";
    }
  }

  private String parseTemperature(Document document) {
    Element temperatureElement = document.selectFirst(".temp__value");
    return temperatureElement != null ? temperatureElement.text() : "Неизвестно";
  }

  private String parseCondition(Document document) {
    Element conditionElement = document.selectFirst(".link__condition");
    return conditionElement != null ? conditionElement.text() : "Неизвестно";
  }
}
