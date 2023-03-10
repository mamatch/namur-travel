package com.djoumatch.test.flight;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public record FlightDTO(
        String departureCity,
        String arrivalCity,
        Float price,
        Float weightAvalaible,
        LocalDate departureDate,
        LocalDate arrivalDate
) {

}
