package com.djoumatch.test.flight;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

/**
 * Represent the request body used to add a flight
 *
 * @param departureAirportId
 * @param arrivalAirportId
 * @param departureDate
 * @param arrivalDate
 * @param weightAvailable
 * @param price
 * @param contact
 */
public record FlightAddRequest(
        String departureAirportId,
        String arrivalAirportId,
        LocalDate departureDate,
        LocalDate arrivalDate,
        Float weightAvailable,
        Float price,
        String contact
) {
}
