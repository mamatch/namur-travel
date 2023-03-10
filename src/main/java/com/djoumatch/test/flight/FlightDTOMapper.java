package com.djoumatch.test.flight;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class FlightDTOMapper implements Function<Flight, FlightDTO> {

    @Override
    public FlightDTO apply(Flight flight) {
        return new FlightDTO(
                flight.getDepartureAirport().getCity().getName(),
                flight.getArrivalAirport().getCity().getName(),
                flight.getPrice(),
                flight.getWeightAvailable(),
                flight.getDepartureDate(),
                flight.getArrivalDate()
        );
    }
}
