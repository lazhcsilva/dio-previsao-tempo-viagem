package dio.tempo_diario.dto;

public record ForecastHourDTO(String time,
                              double tempC,
                              String condition,
                              int humidity,
                              double feelslikeCelsius,
                              double windchillCelsius,
                              double heatindex,
                              double chanceOfRain,
                              double uv) {
}
