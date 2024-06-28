package dio.tempo_diario.dto;

public record ForecastDayDTO(double maxC,
                             double minC,
                             double avgC,
                             double avgHumidity,
                             ForecastHourDTO hourDTO) {
}
