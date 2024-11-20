package org.baopen753.bookingappbackend.configurations;

import jakarta.servlet.http.HttpServletRequest;
import org.baopen753.bookingappbackend.exception.MyAccessDeniedHandlerImpl;
import org.baopen753.bookingappbackend.exception.MyBasicAuthenticationEntryPoint;
import org.baopen753.bookingappbackend.filters.CsrfCookieFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.*;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;


@Configuration
@EnableWebSecurity  // active spring web security
@EnableMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        // session is created for every request, even if authentication is not needed
        http.sessionManagement(ssm -> ssm.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        // makes Spring Security automatically save the SecurityContext at the end of each request
        http.securityContext(context -> context.requireExplicitSave(false));

        // cors configuration
        http.cors(corsConfig -> corsConfig.configurationSource(corsConfigSource -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));   // Origin of frontend
            config.setAllowedMethods(Collections.singletonList("*"));                       // Access all methods
            config.setAllowCredentials(true);
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setMaxAge(3600L);
            return config;
        }));

        // csrf configuration
        http.csrf(csrfConfig -> csrfConfig.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));
        http.csrf(csrfConfig -> csrfConfig.csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler()));
        http.csrf(csrfConfig -> csrfConfig.ignoringRequestMatchers("api/v1/users/register"));

        http.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);       // once basic authN is completed, spring fw will generate csrf token

        http.formLogin(Customizer.withDefaults());
//      http.formLogin(AbstractHttpConfigurer::disable);       if encounters errors, send back to /login

        http.httpBasic(hbc -> hbc.authenticationEntryPoint(new MyBasicAuthenticationEntryPoint()));            // config with customized AuthenticationEntryPoint
//      http.exceptionHandling(ehc -> ehc.authenticationEntryPoint(new MyBasicAuthenticationEntryPoint()));    // config globally with customized AuthenticationEntryPoint
        http.exceptionHandling(ehc -> ehc.accessDeniedHandler(new MyAccessDeniedHandlerImpl()));               // config globally with customized AccessDeniedHandler

        http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.requestMatchers("api/v1/auth/login", "api/v1/users/register").permitAll()
                .requestMatchers(HttpMethod.PATCH, "api/v1/services/{serviceId}").hasAuthority("MANAGER")
                .anyRequest().authenticated());
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
}
