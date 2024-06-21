package dio.tempo_diario.controller;

import dio.tempo_diario.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Operation(summary = "Get weather",
            description = "Pass city name (Example: London) and if you want to obtain data on air quality (yes or no)")
    @GetMapping("/v1/current.json")
    public Map<String, Object> checkWeatherNow(@RequestParam("q") String locale,
                                               @RequestParam("aqi") String aqi) {
        return weatherService.checkWeatherNow(locale, aqi);
    }

    @Operation(summary = "Get weather in future",
            description = "Pass city name (Example: London) and the date between 14 days and 300 days from today in the future")
    @GetMapping("/v1/future.json")
    public Map<String, Object> checkWeatherInFuture(@RequestParam("q") String locale,
                                                    @RequestParam("dt") String date) {
        return weatherService.checkWeatherInFuture(locale, date);
    }

}
