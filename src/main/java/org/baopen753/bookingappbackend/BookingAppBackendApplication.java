package org.baopen753.bookingappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class BookingAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingAppBackendApplication.class, args);
    }

}
