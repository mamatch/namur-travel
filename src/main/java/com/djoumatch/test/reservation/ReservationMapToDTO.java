package com.djoumatch.test.reservation;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ReservationMapToDTO implements Function<Reservation, ReservationDTO> {
    @Override
    public ReservationDTO apply(Reservation reservation) {

        return new ReservationDTO(
                reservation.getReservationDate(),
                reservation.getWeightReserved(),
                reservation.getFlight().getDepartureDate()
        );

    }
}
