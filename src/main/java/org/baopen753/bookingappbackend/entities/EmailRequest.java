package org.baopen753.bookingappbackend.entities;

import lombok.Data;

@Data
public class EmailRequest {
    private String toEmail;
    private String subject;
    private String message;
}
