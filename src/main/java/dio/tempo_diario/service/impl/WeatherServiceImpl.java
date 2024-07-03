package dio.tempo_diario.service.impl;

import dio.tempo_diario.dto.*;
import dio.tempo_diario.handler.BusinessException;
import dio.tempo_diario.service.WeatherAPIService;
import dio.tempo_diario.service.WeatherService;
import dio.tempo_diario.utils.DateConverter;
import feign.FeignException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherAPIService weatherAPIService;

    public WeatherServiceImpl(WeatherAPIService weatherAPIService) {
        this.weatherAPIService = weatherAPIService;
    }

    @Override
    public WeatherDTO getWeatherNow(String locale) {
        Map<String, Object> originalResponse = getStringObjectMap(locale);
        return mapToWeatherNowResponse(originalResponse);
    }

    @Override
    public ForecastDTO getWeatherInFuture(String locale, String date) {
        String newDate = DateConverter.convert(date);

        Map<String, Object> originalResponse = getStringObjectMap(locale, newDate);

        return mapToWeatherFutureResponse(originalResponse);
    }

    private Map<String, Object> getStringObjectMap(String locale) {
        Map<String, Object> originalResponse;
        try {
            originalResponse = weatherAPIService.checkWeatherNow(key, locale, aqi);
        } catch (FeignException e) {
            String errorResponse = e.contentUTF8();
            JSONObject jsonObject = new JSONObject(errorResponse);
            JSONObject error = jsonObject.getJSONObject("error");
            String errorMessage = error.getString("message");
            throw new BusinessException(errorMessage);
        }

        if (originalResponse.containsKey("error")) {
            Map<String, Object> error = (Map<String, Object>) originalResponse.get("error");
            String errorMessage = (String) error.get("message");
            throw new BusinessException(errorMessage);
        }
        return originalResponse;
    }

    private Map<String, Object> getStringObjectMap(String locale, String newDate) {
        Map<String, Object> originalResponse;
        try {
            originalResponse = weatherAPIService.checkWeatherInFuture(key, locale, newDate);
        } catch (FeignException e) {
            String errorResponse = e.contentUTF8();
            JSONObject jsonObject = new JSONObject(errorResponse);
            JSONObject error = jsonObject.getJSONObject("error");
            String errorMessage = error.getString("message");
            throw new BusinessException(errorMessage);
        }

        if (originalResponse.containsKey("error")) {
            Map<String, Object> error = (Map<String, Object>) originalResponse.get("error");
            String errorMessage = (String) error.get("message");
            throw new BusinessException(errorMessage);
        }
        return originalResponse;
    }

    private ForecastDTO mapToWeatherFutureResponse(Map<String, Object> originalResponse) {
        Map<String, Object> forecast = (Map<String, Object>) originalResponse.get("forecast");
        Map<String, Object> forecastDay = ((List<Map<String, Object>>) forecast.get("forecastday")).get(0);
        Map<String, Object> day = (Map<String, Object>) forecastDay.get("day");
        List<Map<String, Object>> hourList = (List<Map<String, Object>>) forecastDay.get("hour");

        List<ForecastHourDTO> hourDTOList = mapListHours(hourList);

        ForecastDayDTO forecastDayDTO = new ForecastDayDTO(
                Double.parseDouble(day.get("maxtemp_c").toString()),
                Double.parseDouble(day.get("mintemp_c").toString()),
                Double.parseDouble(day.get("avgtemp_c").toString()),
                Double.parseDouble(day.get("avghumidity").toString()),
                hourDTOList
        );

        return new ForecastDTO(forecastDay.get("date").toString(), forecastDayDTO);
    }

    private static List<ForecastHourDTO> mapListHours(List<Map<String, Object>> hourList) {
        return hourList.stream()
                .map(hour -> new ForecastHourDTO(
                        hour.get("time").toString(),
                        Double.parseDouble(hour.get("temp_c").toString()),
                        ((Map<String, Object>)hour.get("condition")).get("text").toString(),
                        Integer.parseInt(hour.get("humidity").toString()),
                        Double.parseDouble(hour.get("feelslike_c").toString()),
                        Double.parseDouble(hour.get("windchill_c").toString()),
                        Double.parseDouble(hour.get("heatindex_c").toString()),
                        Double.parseDouble(hour.get("chance_of_rain").toString()),
                        Double.parseDouble(hour.get("uv").toString())
                )).toList();
    }

    private WeatherDTO mapToWeatherNowResponse(Map<String, Object> originalResponse) {
        Map<String, String> location = (Map<String, String>) originalResponse.get("location");
        LocationDTO locationDTO = new LocationDTO(location.get("name"), location.get("region"),
                location.get("country"));

        Map<String, Object> current = (Map<String, Object>) originalResponse.get("current");
        WeatherInfoDTO weatherInfoDTO = new WeatherInfoDTO(
                Double.parseDouble(current.get("temp_c").toString()),
                Double.parseDouble(current.get("feelslike_c").toString()),
                Double.parseDouble(current.get("windchill_c").toString()),
                Integer.parseInt(current.get("humidity").toString()),
                ((Map<String, Object>)current.get("condition")).get("text").toString());

        return new WeatherDTO(locationDTO, weatherInfoDTO);
    }

    private static final String key = "your-key-here";
    private static final String aqi = "no";

}
