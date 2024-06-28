package dio.tempo_diario.dto;

public record WeatherInfoDTO(double temperatureInCelsius,
                             double feelsLikeInCelsius,
                             double windchillInCelsius,
                             int humidity,
                             String condition) {
}
