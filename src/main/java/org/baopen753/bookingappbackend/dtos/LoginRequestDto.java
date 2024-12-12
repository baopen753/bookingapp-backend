package org.baopen753.bookingappbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginRequestDto {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}
