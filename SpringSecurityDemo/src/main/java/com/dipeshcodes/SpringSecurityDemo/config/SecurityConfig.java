package com.dipeshcodes.SpringSecurityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // disable csrf
        http.csrf(customizer -> customizer.disable());
        // add authentication
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());

        // add login form
//        http.formLogin(Customizer.withDefaults());

        // add http basic
        http.httpBasic(Customizer.withDefaults());

        // making REST API stateless
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }
}
