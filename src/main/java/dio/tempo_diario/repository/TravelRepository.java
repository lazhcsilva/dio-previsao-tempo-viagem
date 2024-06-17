package dio.tempo_diario.repository;

import dio.tempo_diario.model.Travel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long> {
}
