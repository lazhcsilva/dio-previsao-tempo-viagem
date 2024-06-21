package dio.tempo_diario.service.impl;

import dio.tempo_diario.service.WeatherAPIService;
import dio.tempo_diario.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherAPIService weatherAPIService;

    public WeatherServiceImpl(WeatherAPIService weatherAPIService) {
        this.weatherAPIService = weatherAPIService;
    }

    @Override
    public Map<String, Object> checkWeatherNow(String locale, String aqi) {
        Map<String, Object> originalResponse = weatherAPIService.checkWeatherNow(key, locale, aqi);
        return mapToWeatherResponse(originalResponse);
    }

    @Override
    public Map<String, Object> checkWeatherInFuture(String locale, String date) {
        return weatherAPIService.checkWeatherInFuture(key, locale, date);
    }

    private Map<String, Object> mapToWeatherResponse(Map<String, Object> originalResponse) {
        Map<String, Object> filteredResponse = new HashMap<>();

        Map<String, Object> location = (Map<String, Object>) originalResponse.get("location");
        Map<String, Object> filteredLocation = new HashMap<>();
        filteredLocation.put("name", location.get("name"));
        filteredLocation.put("country", location.get("country"));

        Map<String, Object> current = (Map<String, Object>) originalResponse.get("current");
        Map<String, Object> filteredCurrent = new HashMap<>();
        filteredCurrent.put("temp_c", current.get("temp_c"));
        filteredCurrent.put("is_day", current.get("is_day"));
        filteredCurrent.put("wind_dir", current.get("wind_dir"));
        filteredCurrent.put("humidity", current.get("humidity"));
        filteredCurrent.put("cloud", current.get("cloud"));
        filteredCurrent.put("feelslike_c", current.get("feelslike_c"));
        filteredCurrent.put("uv", current.get("uv"));

        // Processar a parte "condition" dentro de "current"
        Map<String, Object> condition = (Map<String, Object>) current.get("condition");
        Map<String, Object> filteredCondition = new HashMap<>();
        filteredCondition.put("text", condition.get("text"));
        filteredCurrent.put("condition", filteredCondition);

        // Montar a resposta filtrada
        filteredResponse.put("location", filteredLocation);
        filteredResponse.put("current", filteredCurrent);

        return filteredResponse;
    }

    private static final String key = "ad073ba3795d4cc49c043341241606";

}
