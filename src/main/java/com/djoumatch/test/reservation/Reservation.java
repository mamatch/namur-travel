package com.djoumatch.test.reservation;

import com.djoumatch.test.flight.Flight;
import com.djoumatch.test.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull
    private User reserver;
    @ManyToOne
    @NotNull
    private Flight flight;
    @NotNull
    private LocalDate reservationDate;
    @NotNull
    private Float weightReserved;
}
