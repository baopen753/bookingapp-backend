package org.baopen753.bookingappbackend.events;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEvents {

    private static final Log LOGGER = LogFactory.getLog(AuthenticationEvents.class);

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent successEvent) {
        LOGGER.info("Authentication success with username: " + successEvent.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failureEvent) {
        LOGGER.info("Authentication failure with username: " + failureEvent.getAuthentication().getName());
    }
}
