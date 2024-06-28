package dio.tempo_diario.dto;

import java.util.List;

public record ForecastDayDTO(double maxC,
                             double minC,
                             double avgC,
                             double avgHumidity,
                             List<ForecastHourDTO> hourDTO) {
}
