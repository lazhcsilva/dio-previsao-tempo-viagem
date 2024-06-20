package dio.tempo_diario.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "weatherapi", url = "http://api.weatherapi.com")
public interface WeatherAPIService {

    @GetMapping("/v1/current.json")
    Map<String, Object> checkWeatherNow(@RequestParam("key") String key, @RequestParam("q") String locale,
                                        @RequestParam("aqi") String aqi);

    @GetMapping("/v1/future.json")
    Map<String, Object> checkWeatherInFuture(@RequestParam("key") String key, @RequestParam("q") String locale,
                                             @RequestParam("dt") String date);

}
