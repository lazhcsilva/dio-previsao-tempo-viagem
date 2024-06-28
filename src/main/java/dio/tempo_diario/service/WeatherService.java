package dio.tempo_diario.service;

import dio.tempo_diario.dto.ForecastDTO;
import dio.tempo_diario.dto.WeatherDTO;

public interface WeatherService {
    WeatherDTO getWeatherNow(String locale);
    ForecastDTO getWeatherInFuture(String locale, String date);
}
