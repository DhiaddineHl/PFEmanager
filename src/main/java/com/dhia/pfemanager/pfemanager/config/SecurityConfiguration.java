package com.dhia.pfemanager.pfemanager.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

import static com.dhia.pfemanager.pfemanager.user.appUser.Permission.*;
import static com.dhia.pfemanager.pfemanager.user.appUser.UserRole.*;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> auth
                        .requestMatchers("/api/v1/auth/**").permitAll()

//                        .requestMatchers("/api/v1/demo/intern/**").hasAnyRole(ENTERPRISE.name(), INTERN.name())
//                        .requestMatchers(HttpMethod.GET,"/api/v1/demo/intern/**").hasAnyAuthority(ENTERPRISE_READ.name(), INTERN_READ.name())
//
//                        .requestMatchers("/api/v1/demo/enterprise/**").hasRole(ENTERPRISE.name())
//                        .requestMatchers(HttpMethod.GET,"/api/v1/demo/enterprise/**").hasAuthority(ENTERPRISE_READ.name())
//
//                        .requestMatchers("/api/v1/enterprises/**").hasRole(SUPER_ADMIN.name())
//                        .requestMatchers(HttpMethod.GET,"/api/v1/enterprises/**").hasAuthority(SUPER_ADMIN_READ.name())
//
//                                .requestMatchers("/api/v1/enterprises/**").hasRole(SUPER_ADMIN.name())
//                        .requestMatchers(HttpMethod.PUT,"/api/v1/enterprises/**").hasAuthority(SUPER_ADMIN_READ.name())
//
//                                .requestMatchers("/api/v1/supervisor/**").hasRole(ENTERPRISE.name())
//                        .requestMatchers(HttpMethod.GET,"/api/v1/enterprises/**").hasAuthority(ENTERPRISE_READ.name())
//                                .requestMatchers("/api/v1/intern/**").hasRole(ENTERPRISE.name())
//                        .requestMatchers(HttpMethod.GET,"/api/v1/intern/**").hasAuthority(ENTERPRISE_READ.name())
//
//                                .requestMatchers("/api/v1/supervisor/**").hasRole(ENTERPRISE.name())
//                        .requestMatchers(HttpMethod.PUT,"/api/v1/enterprises/**").hasAuthority(ENTERPRISE_CREATE.name())
//


                        .anyRequest()
                                .authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//                .logout()
//                .addLogoutHandler(null)
//                .logoutSuccessHandler((
//                        (request, response, authentication) -> SecurityContextHolder.clearContext()
//                        ));

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "DELETE", "PUT","OPTIONS"));
        configuration.setAllowedHeaders(List.of("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }



}
