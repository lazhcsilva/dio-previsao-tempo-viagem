package dio.tempo_diario.repository;

import dio.tempo_diario.model.Locality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository extends CrudRepository<Locality, String> {
}
