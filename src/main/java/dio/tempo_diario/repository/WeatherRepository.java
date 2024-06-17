package dio.tempo_diario.repository;

import dio.tempo_diario.model.WeatherReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherReport, Long> {
}
