package org.baopen753.bookingappbackend.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
