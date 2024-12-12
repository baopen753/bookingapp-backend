package org.baopen753.bookingappbackend.services.userservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public String getAuthenticatedUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated())
            throw new UsernameNotFoundException("No authenticated user found");
        return authentication.getName();
    }
}