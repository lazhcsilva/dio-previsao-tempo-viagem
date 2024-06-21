package dio.tempo_diario.service.impl;

import dio.tempo_diario.model.Travel;
import dio.tempo_diario.repository.TravelRepository;
import dio.tempo_diario.service.TravelService;
import dio.tempo_diario.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;
    private final WeatherService weatherService;

    public TravelServiceImpl(TravelRepository travelRepository, WeatherService weatherService) {
        this.travelRepository = travelRepository;
        this.weatherService = weatherService;
    }

    @Override
    public Iterable<Travel> getAllTravels() {
        if (travelRepository.findAll() == null) {

        }
        return travelRepository.findAll();
    }

    @Override
    public Travel getTravelById(Long id) {
        Optional<Travel> travel = travelRepository.findById(id);
        return travel.orElse(null);
    }

    @Override
    public void insertTravel(Travel travel) {
        travelRepository.save(travel);
    }

    @Override
    public void updateTravel(Long id, Travel travel) {
        Optional<Travel> travelDb = travelRepository.findById(id);
        if (travelDb.isPresent()) {
            travelRepository.save(travel);
        }
    }

    @Override
    public void deleteTravel(Long id) {
        travelRepository.deleteById(id);
    }
}
