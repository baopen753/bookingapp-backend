package org.baopen753.bookingappbackend.entity;

import lombok.Data;

@Data
public class EmailRequest {
    private String toEmail;
    private String subject;
    private String message;
}
