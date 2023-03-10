package com.djoumatch.test.location;

import com.djoumatch.test.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;


    public Airport getAirportById(String id) {
        return this.airportRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, Airport.class.getName()));
    }

}
