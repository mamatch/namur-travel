package com.djoumatch.test.reservation;

import com.djoumatch.test.flight.Flight;
import com.djoumatch.test.flight.FlightService;
import com.djoumatch.test.user.User;
import com.djoumatch.test.user.UserRepository;
import com.djoumatch.test.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ReservationReqMapToReservation implements Function<ReservationRequest, Reservation> {

    private final UserService userService;
    private final FlightService flightService;

    @Override
    public Reservation apply(ReservationRequest reservationRequest) {
        Flight flight = flightService.getById(reservationRequest.flightId());
        User user = userService.getById(reservationRequest.userId());
        return Reservation.builder()
                .reserver(user)
                .reservationDate(reservationRequest.reservationDate())
                .flight(flight)
                .weightReserved(reservationRequest.weightReserved())
                .build();
    }
}
