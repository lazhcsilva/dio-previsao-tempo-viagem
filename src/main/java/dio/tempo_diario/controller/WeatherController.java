package dio.tempo_diario.controller;

import dio.tempo_diario.dto.ForecastDTO;
import dio.tempo_diario.dto.WeatherDTO;
import dio.tempo_diario.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Operation(summary = "Get weather",
            description = "Pass city name (Example: London)")
    @GetMapping
    public WeatherDTO checkWeatherNow(@RequestParam("q") String locale) {
        return weatherService.getWeatherNow(locale);
    }

    @Operation(summary = "Get weather in future",
            description = "Pass city name (Example: London) and the date between 14 days and 300 days from today in the future")
    @GetMapping("/future")
    public ForecastDTO checkWeatherInFuture(@RequestParam("q") String locale,
                                            @RequestParam("dt") String date) {
        return weatherService.getWeatherInFuture(locale, date);
    }

}
