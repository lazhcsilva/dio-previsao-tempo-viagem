package dio.tempo_diario.controller;

import dio.tempo_diario.model.Travel;
import dio.tempo_diario.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("travels")
public class TravelController {

    @Autowired
    private TravelService travelService;

//    @GetMapping
//    public ResponseEntity<Iterable<Travel>> getAllTravels() {
//        return ResponseEntity.of(travelService.getAll());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Travel> getTravelById(@PathVariable Long id) {
        return ResponseEntity.ok(travelService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Travel> insertTravel(@RequestBody Travel travel) {
        travelService.insert(travel);
        return ResponseEntity.ok(travel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Travel> updateTravel(@PathVariable Long id, @RequestBody Travel travel) {
        travelService.update(id, travel);
        return ResponseEntity.ok(travel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTravel(@PathVariable Long id) {
        travelService.delete(id);
        return ResponseEntity.ok().build();
    }

}
