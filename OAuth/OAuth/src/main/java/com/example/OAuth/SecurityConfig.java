package com.example.OAuth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf->csrf.disable());
//        httpSecurity.formLogin(login->login.loginPage("/customlogin.html"));
        httpSecurity.authorizeHttpRequests(request->request.requestMatchers("/customlogin.html").permitAll());

        httpSecurity.authorizeHttpRequests(request->request.anyRequest().authenticated());

        httpSecurity.oauth2Login(login->login.loginPage("/customlogin.html"));
        return httpSecurity.build();
    }
}
