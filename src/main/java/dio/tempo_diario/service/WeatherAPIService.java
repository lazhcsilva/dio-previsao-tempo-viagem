package dio.tempo_diario.service;

import dio.tempo_diario.model.WeatherReport;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "weatherapi", url = "http://api.weatherapi.com/")
public interface WeatherAPIService {

    @GetMapping("v1/current.json?key={key}&q={locale}&aqi=no")
    WeatherReport weatherReport(@PathVariable("key") String key, @PathVariable("locale") String locale);

}
