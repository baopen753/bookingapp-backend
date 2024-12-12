package org.baopen753.bookingappbackend.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.baopen753.bookingappbackend.services.userservice.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect

// this class separates AuthenticationService which is a cutting-concern through the application
public class AuthenticatedAspect {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticatedAspect(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Before("@annotation(org.baopen753.bookingappbackend.aop.annotations.Authenticated)")
    public void authenticatedUser() {
        String username = authenticationService.getAuthenticatedUsername();
        UserContext.setAuthenticatedUsername(username);
    }

    @After("@annotation(org.baopen753.bookingappbackend.aop.annotations.Authenticated)")
    public void clearUserContext() {
        UserContext.clear();
    }

}
