package ru.khananov.servlets;

import ru.khananov.factories.WeatherServiceFactory;
import ru.khananov.services.WeatherService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getWeather")
public class WeatherServlet extends HttpServlet {
  private final WeatherService weatherService;

  public WeatherServlet() {
    this.weatherService = WeatherServiceFactory.getWeatherService();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String latitude = req.getParameter("latitude");
    String longitude = req.getParameter("longitude");

    String weatherResponse = weatherService.getWeather(latitude, longitude);
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/plain");
    PrintWriter out = resp.getWriter();
    out.println(weatherResponse);
  }
}
