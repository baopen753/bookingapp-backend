package org.baopen753.bookingappbackend.mappers;

import org.baopen753.bookingappbackend.responses.service.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public static UserResponse userToUserResponse(UserDetails userDetails){
        UserResponse userResponse = new UserResponse();
        List<String> authorities = new ArrayList<>();
        userDetails.getAuthorities().forEach(authority -> authorities.add(authority.getAuthority()));

        userResponse.setUsername(userDetails.getUsername());
        userResponse.setAuthorities(authorities);
        userResponse.setEnabled(userDetails.isEnabled());
        return userResponse;
    }
}
