package com.restaurant.restaurant.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.sessionManagement(sessionManagement->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
                cors(cors->{
                 cors.configurationSource(new CorsConfigurationSource() {
                     @Override
                     public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                          CorsConfiguration cfg = new CorsConfiguration();
                          cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
                          cfg.setAllowedMethods(Collections.singletonList("*"));
                          cfg.setAllowCredentials(true);
                          cfg.setAllowedHeaders(Collections.singletonList("*"));
                          cfg.setExposedHeaders(Arrays.asList("Authorization"));
                        return cfg;
                     }
                 });
                })
                .authorizeHttpRequests(auth->{

            auth.requestMatchers("/user/login").hasRole("ADMIN")
                    .requestMatchers("/user/*").hasRole("CUSTOMER")

                    .requestMatchers("/menu/*").hasRole("ADMIN")
                    .requestMatchers("/menu/read").hasRole("CUSTOMER")

                    .requestMatchers("/item/*").hasRole("ADMIN")
                    .requestMatchers("/item/read").hasRole("CUSTOMER")

                    .requestMatchers("/order/update","/order/read").hasRole("ADMIN")
                    .requestMatchers("/order/create","/order/delete","/order/read").hasRole("CUSTOMER")

                    .requestMatchers("/orders/read").hasRole("ADMIN")
                    .requestMatchers("/orders/*").hasRole("CUSTOMER")

                     .anyRequest().authenticated();
        })
                .addFilterAfter(new JwtGenerator(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class)
                .csrf(csrf->csrf.disable()).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
                 return http.build();
    }

    @Bean
     public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
     }

}
