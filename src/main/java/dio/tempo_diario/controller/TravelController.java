package dio.tempo_diario.controller;

import dio.tempo_diario.model.Travel;
import dio.tempo_diario.service.TravelService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("travel")
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @Operation(summary = "Get all travels")
    @GetMapping
    public ResponseEntity<Iterable<Travel>> getAllTravels() {
        return ResponseEntity.ok(travelService.getAllTravels());
    }

    @Operation(summary = "Get specific travel by ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USERS')")
    public ResponseEntity<Travel> getTravelById(@PathVariable Long id) {
        return ResponseEntity.ok(travelService.getTravelById(id));
    }

    @Operation(summary = "Insert new travel")
    @PostMapping
    @PreAuthorize("hasAnyRole('USERS')")
    public ResponseEntity<Travel> insertTravel(@RequestBody Travel travel) {
        travelService.insertTravel(travel);
        return ResponseEntity.ok(travel);
    }

    @Operation(summary = "Update specific travel by ID")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USERS')")
    public ResponseEntity<Travel> updateTravel(@PathVariable Long id, @RequestBody Travel travel) {
        travelService.updateTravel(id, travel);
        return ResponseEntity.ok(travel);
    }

    @Operation(summary = "Delete specific travel by ID")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('USERS')")
    public ResponseEntity<Void> deleteTravel(@PathVariable Long id) {
        travelService.deleteTravel(id);
        return ResponseEntity.ok().build();
    }

}
