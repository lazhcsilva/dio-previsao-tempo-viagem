package dio.tempo_diario.service.impl;

import dio.tempo_diario.handler.BusinessException;
import dio.tempo_diario.model.Travel;
import dio.tempo_diario.repository.TravelRepository;
import dio.tempo_diario.service.TravelService;
import dio.tempo_diario.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;

    public TravelServiceImpl(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    @Override
    public Iterable<Travel> getAllTravels() {
        Iterable<Travel> travels = travelRepository.findAll();
        if (!travels.iterator().hasNext()) {
            throw new BusinessException("No records saved.");
        }
        return travels;
    }

    @Override
    public Travel getTravelById(Long id) {
        Optional<Travel> travel = travelRepository.findById(id);
        return travel.orElseThrow(() -> new BusinessException("Id not Found."));
    }

    @Override
    public void insertTravel(Travel travel) {
        if (travel.getName() == null|| travel.getDateTravel() == null || travel.getCityName() == null) {
            throw new BusinessException("You need to fill in your name, date and the name of the city.");
        }
        travelRepository.save(travel);
    }

    @Override
    public void updateTravel(Long id, Travel travel) {
        Optional<Travel> travelDb = travelRepository.findById(id);
        if (travelDb.isEmpty()) {
            throw new BusinessException("Id not found.");
        }
        travelRepository.save(travel);
    }

    @Override
    public void deleteTravel(Long id) {
        Travel travel = getTravelById(id);
        travelRepository.delete(travel);
    }
}
