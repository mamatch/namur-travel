package com.djoumatch.test.flight;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void addFlight(@RequestBody FlightAddRequest flightAddRequest) {
        this.flightService.addFlight(flightAddRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable("id") String id) {
        this.flightService.deleteFlight(id);
    }

}
