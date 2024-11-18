package org.baopen753.bookingappbackend.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.util.Date;

public class MyAccessDeniedHandlerImpl implements AccessDeniedHandler {

    private static final String RESPONSE_CONTENT_TYPE = "application/json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        // ErrorDTO
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimeStamp(new Date());
        errorDTO.setStatus(HttpStatus.FORBIDDEN.value());
        errorDTO.setPath(request.getServletPath());
        errorDTO.addError(accessDeniedException.getMessage());

        String jsonResponse = objectMapper.writeValueAsString(errorDTO);

        response.setHeader("Denied-Access", "Authorization failed");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(RESPONSE_CONTENT_TYPE);
        response.getWriter().write(jsonResponse);
    }
}
