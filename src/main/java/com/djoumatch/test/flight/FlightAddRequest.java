package com.djoumatch.test.flight;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record FlightAddRequest(
        String departureAirportId,
        String arrivalAirportId,
        LocalDate departureDate,
        LocalDate arrivalDate,
        Float weigthAvailable,
        Float price,
        String contact
) {
}
