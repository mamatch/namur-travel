package com.djoumatch.test.reservation;

import lombok.Builder;

import java.time.LocalDate;

public record ReservationDTO(
        LocalDate ReservationDate,
        Float weightReserved,
        LocalDate dateOfTheFlight
) {

}
