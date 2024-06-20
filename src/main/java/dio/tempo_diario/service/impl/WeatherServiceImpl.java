package dio.tempo_diario.service.impl;

import dio.tempo_diario.service.WeatherAPIService;
import dio.tempo_diario.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherAPIService weatherAPIService;

    public WeatherServiceImpl(WeatherAPIService weatherAPIService) {
        this.weatherAPIService = weatherAPIService;
    }

    @Override
    public Map<String, Object> checkWeatherNow(String locale, String aqi) {
        return weatherAPIService.checkWeatherNow(key, locale, aqi);
    }

    @Override
    public Map<String, Object> checkWeatherInFuture(String locale, String date) {
        return weatherAPIService.checkWeatherInFuture(key, locale, date);
    }

    private static final String key = "ad073ba3795d4cc49c043341241606";

}
