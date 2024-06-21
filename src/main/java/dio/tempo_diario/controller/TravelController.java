package dio.tempo_diario.controller;

import dio.tempo_diario.model.Travel;
import dio.tempo_diario.service.TravelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("travel")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Travel>> getAllTravels() {
        return ResponseEntity.ok(travelService.getAllTravels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Travel> getTravelById(@PathVariable Long id) {
        return ResponseEntity.ok(travelService.getTravelById(id));
    }

    @PostMapping("/postTravel")
    public ResponseEntity<Travel> insertTravel(@RequestBody Travel travel) {
        travelService.insertTravel(travel);
        return ResponseEntity.ok(travel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Travel> updateTravel(@PathVariable Long id, @RequestBody Travel travel) {
        travelService.updateTravel(id, travel);
        return ResponseEntity.ok(travel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTravel(@PathVariable Long id) {
        travelService.deleteTravel(id);
        return ResponseEntity.ok().build();
    }

}
