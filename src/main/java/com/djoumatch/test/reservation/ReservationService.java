package com.djoumatch.test.reservation;

import com.djoumatch.test.exception.CanBeReserved;
import com.djoumatch.test.exception.NotFoundException;
import com.djoumatch.test.flight.Flight;
import com.djoumatch.test.flight.FlightService;
import com.djoumatch.test.user.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final FlightService flightService;
    private ReservationReqMapToReservation toReservation;

    @Transactional
    public Reservation reserve(ReservationRequest reservationRequest) {
        // check if the weight to reserve can be
        if (!flightService.canBeReserved(
                reservationRequest.weightReserved(),
                reservationRequest.flightId())
        ) {
            throw new CanBeReserved(reservationRequest.flightId());
        }
        Reservation reservation = toReservation.apply(reservationRequest);
        reservationRepository.save(reservation);
        Flight flightReserved = flightService.getById(reservationRequest.flightId());
        flightReserved.setWeightAvailable(flightReserved.getWeightAvailable() - reservation.getWeightReserved());
        return reservation;
    }

    public Reservation getById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }
}
