package dio.tempo_diario.service;

import dio.tempo_diario.model.Travel;

public interface TravelService {

    Iterable<Travel> getAllTravels();
    Travel getTravelById(Long id);
    void insertTravel(Travel travel);
    void updateTravel(Long id, Travel travel);
    void deleteTravel(Long id);

}
