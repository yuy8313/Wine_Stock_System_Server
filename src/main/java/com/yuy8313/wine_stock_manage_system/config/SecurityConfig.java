package com.yuy8313.wine_stock_manage_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/join", "/login", "/loginProc", "/join", "/joinProc").permitAll()
            .requestMatchers("/admin").hasRole("ADMIN")
            .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated()
        );
    http
        .formLogin(auth -> auth.loginPage("/login")
            .loginProcessingUrl("/loginProc")
            .permitAll()
        );
//    http
//        .csrf(auth -> auth.disable());
    http
        .sessionManagement(auth -> auth
            .maximumSessions(1)
            .maxSessionsPreventsLogin(true)
        );
    http
        .sessionManagement(auth -> auth
            .sessionFixation().changeSessionId()
        );
    http
        .logout(auth -> auth
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
        );
    return http.build();
  }
}
