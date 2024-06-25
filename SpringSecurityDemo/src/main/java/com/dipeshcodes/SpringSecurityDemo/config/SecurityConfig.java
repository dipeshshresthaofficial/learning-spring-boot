package com.dipeshcodes.SpringSecurityDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public AuthenticationProvider authProvider(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

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

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.withDefaultPasswordEncoder()
//                                .username("dipesh")
//                                .password("d@123")
//                                .roles("USER")
//                                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                                .username("admin")
//                                .password("admin")
//                                .roles("ADMIN")
//                                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}
