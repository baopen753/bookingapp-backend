package org.baopen753.bookingappbackend.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.baopen753.bookingappbackend.utils.JwtUtils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;

public class JwtGeneratorFilter extends OncePerRequestFilter {

    private final String JWT_SECRET_KEY;
    private final String JWT_HEADER;
    private final JwtUtils jwtUtils;

    public JwtGeneratorFilter(String jwtSecretKey, String jwtHeader, JwtUtils jwtUtils) {
        JWT_SECRET_KEY = jwtSecretKey;
        JWT_HEADER = jwtHeader;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // get Authentication object after going through BasicAuthenticationFilter
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // check Authentication
        if (authentication != null && authentication.isAuthenticated()) {

            // get HMAC-SHA key value from plain-text
            SecretKey secretKey = jwtUtils.getSecretKey(JWT_SECRET_KEY);

            // generate jwt
            String jwt = jwtUtils.generateToken(secretKey, authentication);

            // assign to response header
            response.addHeader(JWT_HEADER, jwt);
        }
        filterChain.doFilter(request, response);
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getServletPath().equals("/api/v1/users/profile");   // only run this filter when request to /profile path to perform login operation
    }
}


