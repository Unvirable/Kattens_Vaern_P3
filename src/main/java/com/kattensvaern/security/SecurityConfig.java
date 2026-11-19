
package com.kattensvaern.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                // Only logged-in users can access their profile, protected API
                .requestMatchers("/api/profile").authenticated()
                // require login for cats, protected API              
                .requestMatchers("/api/mycats", "/api/mycats/**").authenticated()
                
                // protected HTML pages
                .requestMatchers(
                    "/html/profilePage.html",
                    "/html/myCatPage.html"
                ).authenticated()

                // Public pages and API endpoints
                .requestMatchers(
                    "/api/getCats",
                    "/api/findCatById",
                    "/api/news",
                    "/api/hello",
                    "/api/csrf",
                    "/api/auth/status",
                    "/html/**",
                    "/css/**",
                    "/js/**",
                    "/favicon.ico"
                ).permitAll()
                // All other requests require authentication
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/html/loginPage.html")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/html/newsPage.html", true)
                .failureUrl("/html/loginPage.html?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/html/newsPage.html")
                .permitAll()
            );



        return http.build();
    }
}
