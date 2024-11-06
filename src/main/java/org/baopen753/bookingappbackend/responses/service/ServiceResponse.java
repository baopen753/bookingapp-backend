package org.baopen753.bookingappbackend.responses.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse {

    @JsonProperty("service_id")
    private Integer serviceId;

    @JsonProperty("service_name")
    private String serviceName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("service_price")
    private Double servicePrice;

}
