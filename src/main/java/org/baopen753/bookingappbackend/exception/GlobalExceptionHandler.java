package org.baopen753.bookingappbackend.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDTO handleGenericException(HttpServletRequest request, Exception exception) {
        LOGGER.error("Internal server error: {}", exception.getMessage());

        // customize ResponseBody
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimeStamp(new Date());
        errorDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDTO.setPath(request.getServletPath());
        errorDTO.addError(exception.getMessage());

        return errorDTO;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO handleBadRequestException(HttpServletRequest request, BadRequestException exception) {
        LOGGER.error("Bad request: {}", exception.getMessage());

        // customize Response Body
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimeStamp(new Date());
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDTO.setPath(request.getServletPath());
        errorDTO.addError(exception.getMessage());

        return errorDTO;
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDTO handleDataNotFoundException(HttpServletRequest request, DataNotFoundException exception) {
        LOGGER.error("Data not found: {}", exception.getMessage());

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTimeStamp(new Date());
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setPath(request.getServletPath());
        errorDTO.addError(exception.getMessage());
        return errorDTO;
    }

}
