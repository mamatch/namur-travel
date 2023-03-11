package com.djoumatch.test.flight;

import com.djoumatch.test.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final FlightDTOMapper flightDTOMapper;
    private final FlightRequestMapper flightRequestMapper;

    public List<FlightDTO> all() {
        return this.flightRepository
                .findAll()
                .stream()
                .map(flightDTOMapper)
                .collect(Collectors.toList());
    }

    public void addFlight(FlightAddRequest flightAddRequest) {
        Flight flightToAdd = flightRequestMapper.apply(flightAddRequest);
        flightRepository.save(flightToAdd);
    }

    public void deleteFlight(String id) {
        if (!flightRepository.checksFlightExist(id)) {
            throw new NotFoundException();
        }
        flightRepository.deleteById(id);
    }
}
