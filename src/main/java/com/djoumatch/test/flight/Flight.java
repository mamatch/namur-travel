package com.djoumatch.test.flight;

import com.djoumatch.test.location.Airport;
import com.djoumatch.test.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToOne
    private Airport departureAirport;
    @OneToOne
    private Airport arrivalAirport;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Float weightAvailable;
    private Float price;
    @ManyToOne
    private User userContact;

    public static FlightResponse toResponse(Flight flight) {
        return FlightResponse.builder()
                .arrivalCity(flight.getArrivalAirport().getCity().getName())
                .departureCity(flight.getDepartureAirport().getCity().getName())
                .departureDate(flight.getDepartureDate())
                .arrivalDate(flight.getArrivalDate())
                .price(flight.getPrice())
                .weightAvalaible(flight.getWeightAvailable())
                .build();
    }
}
