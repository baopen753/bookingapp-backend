package org.baopen753.bookingappbackend.events;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationEvents {

    private static final Log LOGGER = LogFactory.getLog(AuthorizationEvents.class);

    @EventListener
    public void onFailure(AuthorizationDeniedEvent deniedEvent) {
        LOGGER.error("Authorization failed for the user: " + deniedEvent.getAuthentication().get().getName() + " due to:" + deniedEvent.getAuthorizationDecision().toString());
    }

}
