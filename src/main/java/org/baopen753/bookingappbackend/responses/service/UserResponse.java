package org.baopen753.bookingappbackend.responses.service;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    @JsonProperty("username")
    private String username;

    @JsonProperty("authorities")
    private List<String> authorities;

    @JsonProperty("enabled")
    private boolean enabled;
}
