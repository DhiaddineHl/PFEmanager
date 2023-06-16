package com.dhia.pfemanager.pfemanager.config;


import com.dhia.pfemanager.pfemanager.user.enterprise.Enterprise;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.dhia.pfemanager.pfemanager.user.Permission.ENTERPRISE_READ;
import static com.dhia.pfemanager.pfemanager.user.Permission.INTERN_READ;
import static com.dhia.pfemanager.pfemanager.user.UserRole.ENTERPRISE;
import static com.dhia.pfemanager.pfemanager.user.UserRole.INTERN;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**").permitAll()

                        .requestMatchers("/api/v1/demo/intern/**").hasAnyRole(ENTERPRISE.name(), INTERN.name())
                        .requestMatchers(HttpMethod.GET,"/api/v1/demo/intern/**").hasAnyAuthority(ENTERPRISE_READ.name(), INTERN_READ.name())

                        .requestMatchers("/api/v1/demo/enterprise/**").hasRole(ENTERPRISE.name())
                        .requestMatchers(HttpMethod.GET,"/api/v1/demo/enterprise/**").hasAuthority(ENTERPRISE_READ.name())

                        .anyRequest().authenticated()
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

}
