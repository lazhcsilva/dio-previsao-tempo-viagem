package dio.tempo_diario.service;

import dio.tempo_diario.model.Travel;

public interface TravelService {

    Iterable<Travel> getAll();
    Travel getById(Long id);
    void insert(Travel travel);
    void update(Long id, Travel travel);
    void delete(Long id);

}
