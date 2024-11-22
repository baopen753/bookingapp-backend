package org.baopen753.bookingappbackend.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.baopen753.bookingappbackend.utils.JwtUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;

public class JwtValidatorFilter extends OncePerRequestFilter {

    private final String JWT_SECRET_KEY;
    private final String JWT_HEADER;
    private final JwtUtils jwtUtils;

    public JwtValidatorFilter(String jwtSecretKey, String jwtHeader, JwtUtils jwtUtils) {
        JWT_SECRET_KEY = jwtSecretKey;
        JWT_HEADER = jwtHeader;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // get jwt from response's header
        String jwt = request.getHeader(JWT_HEADER);

        if (jwt != null) {
            try {

                // get SecretKey based on plain-text format key
                SecretKey secretKey = jwtUtils.getSecretKey(JWT_SECRET_KEY);

                // use SecretKey to verify then get Claims
                Claims claims = Jwts.parser().
                        verifyWith(secretKey).build()
                        .parseSignedClaims(jwt).getPayload();

                String username = claims.get("username").toString();
                String authorities = claims.get("authorities").toString();

                Authentication authenticatedCredential = new UsernamePasswordAuthenticationToken(username, null, AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
                SecurityContextHolder.getContext().setAuthentication(authenticatedCredential);

            } catch (Exception e) {
                throw new BadCredentialsException("Invalid JWT token received: " + jwt);
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().equals("/api/v1/users/profile");   // run filter everytime to validate token except login operation
    }
}
