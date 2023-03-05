package com.djoumatch.test.flight;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class FlightResponse {
    private String departureCity, arrivalCity;
    private Float price, weightAvalaible;
    private LocalDate departureDate, arrivalDate;
}
