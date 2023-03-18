package com.djoumatch.test.flight;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<List<FlightDTO>> findAll() {
        return ResponseEntity.ok(this.flightService.all());
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody FlightAddRequest flightAddRequest) {
        Flight addedFlight = this.flightService.addFlight(flightAddRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedFlight.getId())
                .toUri();
        return ResponseEntity.created(uri).body(addedFlight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable("id") Long id) {
        this.flightService.deleteFlight(id);
    }

}
