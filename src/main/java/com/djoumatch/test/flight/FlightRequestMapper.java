package com.djoumatch.test.flight;

import com.djoumatch.test.location.AirportService;
import com.djoumatch.test.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class FlightRequestMapper implements Function<FlightAddRequest, Flight> {

    private final AirportService airportService;
    private final UserService userService;

    @Override
    public Flight apply(FlightAddRequest flightAddRequest) {
        return Flight.builder()
                .departureAirport(airportService.getAirportById(flightAddRequest.departureAirportId()))
                .arrivalAirport(airportService.getAirportById(flightAddRequest.arrivalAirportId()))
                .departureDate(flightAddRequest.departureDate())
                .arrivalDate(flightAddRequest.arrivalDate())
                .price(flightAddRequest.price())
                .weightAvailable(flightAddRequest.weightAvailable())
                .userContact(userService.getUserByNumber(flightAddRequest.contact()))
                .build();
    }
}
