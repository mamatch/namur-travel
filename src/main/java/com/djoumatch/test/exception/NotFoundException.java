package com.djoumatch.test.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id, String objectClass) {
        super(String.format("The {} with the id {} was not found...", objectClass.getClass(), id));
    }

    public NotFoundException() {
    }
}
