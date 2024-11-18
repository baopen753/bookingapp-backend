package org.baopen753.bookingappbackend.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.util.Date;

public class MyBasicAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final String RESPONSE_CONTENT_TYPE = "application/json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        // ErrorDTO
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimeStamp(new Date());
        errorDTO.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorDTO.setPath(request.getServletPath());
        errorDTO.addError(authException.getMessage());

        String jsonResponse = objectMapper.writeValueAsString(errorDTO);

        response.setHeader("WWW-Authenticate","Unauthorized");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(RESPONSE_CONTENT_TYPE);
        response.getWriter().write(jsonResponse);
    }
}
