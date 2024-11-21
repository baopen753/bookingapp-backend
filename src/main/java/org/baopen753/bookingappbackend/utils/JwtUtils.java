package org.baopen753.bookingappbackend.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtUtils {

    @Value("${jwt.sender}")
    private String sender;

    // generate an HMAC-SHA key from input as a plain-text key
    public SecretKey getSecretKey(String plainTextKey) {
        byte[] bytesOfKey = plainTextKey.getBytes();
        return Keys.hmacShaKeyFor(bytesOfKey);
    }

    public String generateToken(SecretKey secretKey, Authentication authentication) {
        return Jwts.builder()
                .issuer(sender)
                .subject("JWT-Token")
                .claim("username", authentication.getName())
                .claim("authorities", authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")))
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + 1800000))
                .signWith(secretKey)
                .compact();
    }
}
