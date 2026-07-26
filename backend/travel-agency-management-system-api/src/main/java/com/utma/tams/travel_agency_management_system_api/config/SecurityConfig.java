package com.utma.tams.travel_agency_management_system_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(JwtFilter jwtFilter, UserDetailsServiceImpl userDetailsService) {
        this.jwtFilter = jwtFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // public
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/destinations/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/travelpackages/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/guides/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/transportations/**").permitAll()

                        // Specific
                        .requestMatchers(HttpMethod.GET, "/api/users/my").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/users/my").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/cards/my").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/reservations/my").authenticated()

                        // only admin
                        .requestMatchers(HttpMethod.GET, "/api/cards").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/cards/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/users/role/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/users/{id}").hasRole("ADMIN") // ← agrega esto

                        .requestMatchers(HttpMethod.GET, "/api/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/destinations").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/destinations/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/destinations/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/guides").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/guides/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/guides/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/transportations").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/transportations/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/transportations/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/travelpackages").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/travelpackages/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/travelpackages/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/reservations").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/reservations/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/api/reservations/**").hasRole("ADMIN")
                        // any user authenticated
                        .anyRequest().authenticated())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
