package dio.tempo_diario.service.impl;

import dio.tempo_diario.dto.*;
import dio.tempo_diario.service.WeatherAPIService;
import dio.tempo_diario.service.WeatherService;
import dio.tempo_diario.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        Map<String, Object> originalResponse = weatherAPIService.checkWeatherNow(key, locale, aqi);
        return mapToWeatherNowResponse(originalResponse);
    }

    @Override
    public ForecastDTO getWeatherInFuture(String locale, String date) {
        String newDate = Utils.convertDate(date);
        Map<String, Object> originalResponse = weatherAPIService.checkWeatherInFuture(key, locale, newDate);
        return mapToWeatherFutureResponse(originalResponse);
    }

    private ForecastDTO mapToWeatherFutureResponse(Map<String, Object> originalResponse) {
        Map<String, Object> forecast = (Map<String, Object>) originalResponse.get("forecast");
        Map<String, Object> forecastDay = ((List<Map<String, Object>>) forecast.get("forecastday")).get(0);
        Map<String, Object> day = (Map<String, Object>) forecastDay.get("day");
        List<Map<String, Object>> hourList = (List<Map<String, Object>>) forecastDay.get("hour");

        List<ForecastHourDTO> hourDTOList = new ArrayList<>();
        mappingListHours(hourList, hourDTOList);

        ForecastDayDTO forecastDayDTO = new ForecastDayDTO(
                Double.parseDouble(day.get("maxtemp_c").toString()),
                Double.parseDouble(day.get("mintemp_c").toString()),
                Double.parseDouble(day.get("avgtemp_c").toString()),
                Double.parseDouble(day.get("avghumidity").toString()),
                hourDTOList
        );

        return new ForecastDTO(forecastDay.get("date").toString(), forecastDayDTO);
    }

    private static void mappingListHours(List<Map<String, Object>> hourList, List<ForecastHourDTO> hourDTOList) {
        for (Map<String, Object> hour : hourList) {
            ForecastHourDTO forecastHourDTO = new ForecastHourDTO(
                    hour.get("time").toString(),
                    Double.parseDouble(hour.get("temp_c").toString()),
                    ((Map<String, Object>)hour.get("condition")).get("text").toString(),
                    Integer.parseInt(hour.get("humidity").toString()),
                    Double.parseDouble(hour.get("feelslike_c").toString()),
                    Double.parseDouble(hour.get("windchill_c").toString()),
                    Double.parseDouble(hour.get("heatindex_c").toString()),
                    Double.parseDouble(hour.get("chance_of_rain").toString()),
                    Double.parseDouble(hour.get("uv").toString())
            );
            hourDTOList.add(forecastHourDTO);
        }
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

    private static final String key = "ad073ba3795d4cc49c043341241606";
    private static final String aqi = "no";

}
