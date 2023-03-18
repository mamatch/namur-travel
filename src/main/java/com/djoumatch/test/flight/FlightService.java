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

    //public Flight getFlightById(Long id)

    public Flight addFlight(FlightAddRequest flightAddRequest) {
        Flight flightToAdd = flightRequestMapper.apply(flightAddRequest);
        flightRepository.save(flightToAdd);
        return flightToAdd;
    }

    public void deleteFlight(Long id) {
        if (!flightRepository.checksFlightExist(id)) {
            throw new NotFoundException();
        }
        flightRepository.deleteById(id);
    }

    public Flight getById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public Boolean canBeReserved(Float weight, Long id) {
        return flightRepository.checksFlightCanBeReserved(weight, id);
    }
}
