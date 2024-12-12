package org.baopen753.bookingappbackend.responses.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDto {

    @JsonProperty("status")
    private String status;

    @JsonProperty("token")
    private String jwt;
}
