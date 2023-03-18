package com.djoumatch.test.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String number) {
        super(String.format("No user with number %s found", number));
    }
}
