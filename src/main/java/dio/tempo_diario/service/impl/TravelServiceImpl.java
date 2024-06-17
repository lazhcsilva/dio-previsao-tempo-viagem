package dio.tempo_diario.service.impl;

import dio.tempo_diario.model.Locality;
import dio.tempo_diario.model.Travel;
import dio.tempo_diario.repository.LocalityRepository;
import dio.tempo_diario.repository.TravelRepository;
import dio.tempo_diario.service.TravelService;
import dio.tempo_diario.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private LocalityRepository localityRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Travel> getAll() {
        return travelRepository.findAll();
    }

    @Override
    public Travel getById(Long id) {
        Optional<Travel> travel = travelRepository.findById(id);
        return travel.orElse(null);
    }

    @Override
    public void insert(Travel travel) {
        saveTravelWithAddress(travel);
    }

    @Override
    public void update(Long id, Travel travel) {
        Optional<Travel> travelBD = travelRepository.findById(id);
        if (travelBD.isPresent()) {
            saveTravelWithAddress(travel);
        }
    }

    @Override
    public void delete(Long id) {
        travelRepository.deleteById(id);
    }

    private void saveTravelWithAddress(Travel travel) {
        String zipCode = travel.getLocality().getCep();
        Locality locality = localityRepository.findById(travel.getLocality().getCep()).orElseGet(() -> {
            Locality newLocality = viaCepService.checkZipCode(zipCode);
            localityRepository.save(newLocality);
            return newLocality;
        });
        travel.setLocality(locality);
        travelRepository.save(travel);
    }
}
