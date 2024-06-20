package dio.tempo_diario.service;

import java.util.Map;

public interface WeatherService {
    Map<String, Object> checkWeatherNow(String locale, String aqi);
    Map<String, Object> checkWeatherInFuture(String locale, String date);
}
