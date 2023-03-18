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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Airport departureAirport;
    @OneToOne
    private Airport arrivalAirport;
    @Column(nullable = false)
    private LocalDate departureDate;
    @Column(nullable = false)
    private LocalDate arrivalDate;
    @Column(nullable = false)
    private Float weightAvailable;
    @Column(nullable = false)
    private Float price;
    @ManyToOne
    private User userContact;

    public Flight(Airport departureAirport, Airport arrivalAirport, LocalDate departureDate, LocalDate arrivalDate, Float weightAvailable, Float price, User userContact) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.weightAvailable = weightAvailable;
        this.price = price;
        this.userContact = userContact;
    }
}
