package org.baopen753.bookingappbackend.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String entity, Object identifier) {
        super(String.format("%s not found with identifier %s", entity, identifier));
    }
}
