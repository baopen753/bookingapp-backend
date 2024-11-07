package org.baopen753.bookingappbackend.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    @JsonProperty("user_id")
    public Integer userId;

    @JsonProperty("first_name")
    public String firstName;

    @JsonProperty("last_name")
    public String lastName;

    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;

    @JsonProperty("email")
    public String email;

    @JsonProperty("phone_number")
    public String phoneNumber;

    @JsonProperty("role")
    public String role;

    @JsonProperty("avatar")
    public String avatar;

    @JsonProperty("address")
    public AddressDto address;

}
