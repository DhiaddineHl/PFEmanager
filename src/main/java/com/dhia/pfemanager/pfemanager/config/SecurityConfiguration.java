package com.dhia.pfemanager.pfemanager.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                        .requestMatchers("/api/v1/auth/**",
                                "/v2/api-docs",
                                "/v3/api-docs",
                                "/v3/api-docs/**",
                                "/swagger-resources",
                                "/swagger-resources/**",
                                "/configuration/ui",
                                "/configuration/security",
                                "/swagger-ui/**",
                                "/webjars/**",
                                "/swagger-ui.html"

                        ).permitAll()

                                //superAdmin authorities : consult enterprises list , block or enable enterprises;

                                .requestMatchers("/api/v1/enterprises/**").hasRole(SUPER_ADMIN.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/enterprises/**").hasAuthority(SUPER_ADMIN_READ.name())
                                .requestMatchers("/api/v1/enterprises/**").hasRole(SUPER_ADMIN.name())
                                .requestMatchers(HttpMethod.PUT,"/api/v1/enterprises/**").hasAuthority(SUPER_ADMIN_CREATE.name())

                                //enterprise authorities : create topics ,
                                // add activities to topics , consult the list of topics ,
                                //consult the list of supervisors and interns , assign topics to interns and interns to supervisors,
                                //check for the interns progress (todos and tasks they are working on and supervisors comments on them);

                                //topics
                                .requestMatchers("/api/v1/topics/**").hasRole(ENTERPRISE.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/topics/**").hasAuthority(ENTERPRISE_READ.name())
                                .requestMatchers("/api/v1/topics/**").hasRole(ENTERPRISE.name())
                                .requestMatchers(HttpMethod.POST,"/api/v1/topics/**").hasAuthority(ENTERPRISE_READ.name())
                                .requestMatchers("/api/v1/topics/**").hasRole(ENTERPRISE.name())
                                .requestMatchers(HttpMethod.PUT,"/api/v1/topics/**").hasAuthority(ENTERPRISE_READ.name())
                                //todos
                                .requestMatchers("/api/v1/todos/byIntern/{internId}").hasRole(ENTERPRISE.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/todos/byIntern/{internId}").hasAuthority(ENTERPRISE_READ.name())
                                //tasks
                                .requestMatchers("/api/v1/tasks/byIntern/{internId}").hasRole(ENTERPRISE.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/tasks/byIntern/{internId}").hasAuthority(ENTERPRISE_READ.name())
                                //interns
                                .requestMatchers("/api/v1/intern/**").hasRole(ENTERPRISE.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/intern/**").hasAuthority(ENTERPRISE_READ.name())
                                //supervisor
                                .requestMatchers("/api/v1/supervisor/**").hasRole(ENTERPRISE.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/supervisor/**").hasAuthority(ENTERPRISE_READ.name())
                                .requestMatchers("/api/v1/supervisor/**").hasRole(ENTERPRISE.name())
                                .requestMatchers(HttpMethod.PUT,"/api/v1/supervisor/**").hasAuthority(ENTERPRISE_CREATE.name())

                                //supervisor authorities :
                                //consult interns assigned to him , track their progress (see their todos),
                                //and assign tasks to them , and comment their work

                                //intern
                                .requestMatchers("/api/v1/intern/bySupervisor/**").hasRole(SUPERVISOR.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/intern/bySupervisor/**").hasAuthority(SUPERVISOR_READ.name())
                                //topic
                                .requestMatchers("/api/v1/topics/byIntern/**").hasRole(SUPERVISOR.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/topics/byIntern/**").hasAuthority(SUPERVISOR_READ.name())
                                //todos
                                .requestMatchers("/api/v1/todos/byIntern/**").hasRole(SUPERVISOR.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/todos/byIntern/**").hasAuthority(SUPERVISOR_READ.name())
                                //tasks
                                .requestMatchers("/api/v1/tasks/**").hasRole(SUPERVISOR.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/tasks/**").hasAuthority(SUPERVISOR_READ.name())
                                .requestMatchers("/api/v1/tasks/**").hasRole(SUPERVISOR.name())
                                .requestMatchers(HttpMethod.POST,"/api/v1/tasks/**").hasAuthority(SUPERVISOR_CREATE.name())
                                //comment
                                .requestMatchers("/api/v1/comments/**").hasRole(SUPERVISOR.name())
                                .requestMatchers(HttpMethod.POST,"/api/v1/comments/**").hasAuthority(SUPERVISOR_CREATE.name())

                                //intern authorities :
                                //consult the topic assigned to him (activities), add todos , consult tasks and comments

                                //topic
                                .requestMatchers("/api/v1/topics/byIntern/**").hasRole(INTERN.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/topics/byIntern/**").hasAuthority(INTERN_READ.name())

                                //todos
                                .requestMatchers("/api/v1/todos/**").hasRole(INTERN.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/todos/**").hasAuthority(INTERN_READ.name())
                                .requestMatchers("/api/v1/todos/delete/**").hasRole(INTERN.name())
                                .requestMatchers(HttpMethod.DELETE,"/api/v1/todos/delete/**").hasAuthority(INTERN_DELETE.name())

                                //tasks
                                .requestMatchers("/api/v1/tasks/byIntern/**").hasRole(INTERN.name())
                                .requestMatchers(HttpMethod.GET,"/api/v1/tasks/byIntern/**").hasAuthority(INTERN_READ.name())


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
