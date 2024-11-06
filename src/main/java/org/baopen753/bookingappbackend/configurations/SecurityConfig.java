package org.baopen753.bookingappbackend.configurations;

import org.baopen753.bookingappbackend.filters.CsrfCookieFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
//@EnableWebSecurity  // active spring web security
//@EnableMethodSecurity(jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        CsrfTokenRequestAttributeHandler requestAttributeHandler = new CsrfTokenRequestAttributeHandler();
//        requestAttributeHandler.setCsrfRequestAttributeName("_csrf");
//
//        http.securityContext(context -> context.requireExplicitSave(false));
//
//        // config non-session
//        http.sessionManagement(ssm -> ssm.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
//
//        // if encounters errors, send back to /login
//        http.formLogin(AbstractHttpConfigurer::disable);

        http.csrf(AbstractHttpConfigurer::disable);

        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
//
//
//        http.csrf(csrfConfig -> csrfConfig.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
//                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);


        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.requestMatchers(HttpMethod.PATCH, "api/v1/services/{serviceId}").authenticated()
                .requestMatchers(HttpMethod.GET, "api/v1/services/{serviceId}").authenticated()
                .requestMatchers(HttpMethod.GET, "api/v1/services/all}").authenticated()
                .requestMatchers("api/v1/auth/login", "api/v1/users/register").permitAll());
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
