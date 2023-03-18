package com.djoumatch.test.reservation;

import java.time.LocalDate;

public record ReservationRequest(
        Long userId,
        Long flightId,
        Float weightReserved,
        LocalDate reservationDate
) {
}
