package com.DAKR.web.JWT_Auth_DAKR_SOLUTION.config;

import com.DAKR.web.JWT_Auth_DAKR_SOLUTION.security.JwtAuthenticationEntryPoint;
import com.DAKR.web.JWT_Auth_DAKR_SOLUTION.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint point;

    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

//        config
        httpSecurity.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable()).authorizeHttpRequests(
                        auth ->
                                auth.requestMatchers("/home/**")
                                        .hasRole("ADMIN")
                                        .requestMatchers("/auth/login")
                                        .permitAll().anyRequest()
                                        .authenticated())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);


        return httpSecurity.build();
    }
}
