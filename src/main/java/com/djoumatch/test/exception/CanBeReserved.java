package com.djoumatch.test.exception;

public class CanBeReserved extends RuntimeException {
    public CanBeReserved(Long flightId) {
        super(String.format("You cannot reserve the flight %l as weight is too high", flightId));
    }
}
