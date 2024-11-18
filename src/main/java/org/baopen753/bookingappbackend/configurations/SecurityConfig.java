package org.baopen753.bookingappbackend.configurations;

import org.baopen753.bookingappbackend.exception.MyAccessDeniedHandlerImpl;
import org.baopen753.bookingappbackend.exception.MyBasicAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity  // active spring web security
@EnableMethodSecurity(jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        CsrfTokenRequestAttributeHandler requestAttributeHandler = new CsrfTokenRequestAttributeHandler();
//        requestAttributeHandler.setCsrfRequestAttributeName("_csrf");
//
//        http.securityContext(context -> context.requireExplicitSave(false));
//
//        // config non-session
//        http.sessionManagement(ssm -> ssm.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));


        http.csrf(AbstractHttpConfigurer::disable);
//        http.csrf(csrfConfig -> csrfConfig.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
//                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);


        http.formLogin(Customizer.withDefaults());
//      http.formLogin(AbstractHttpConfigurer::disable);       if encounters errors, send back to /login

        http.httpBasic(hbc -> hbc.authenticationEntryPoint(new MyBasicAuthenticationEntryPoint()));          // config with customized AuthenticationEntryPoint
//        http.exceptionHandling(ehc -> ehc.authenticationEntryPoint(new MyBasicAuthenticationEntryPoint()));    // config globally with customized AuthenticationEntryPoint
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
