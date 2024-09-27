package org.baopen753.bookingappbackend.exception;

public class AppointmentServiceNotFoundException extends RuntimeException {
    public AppointmentServiceNotFoundException() {
    }

    public AppointmentServiceNotFoundException(String message) {
        super(message);
    }
}
