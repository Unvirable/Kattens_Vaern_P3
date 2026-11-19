
package com.kattensvaern.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @GetMapping("/api/auth/status")
    public Map<String, Object> getAuthStatus() {

        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        boolean loggedIn = auth != null
                && auth.isAuthenticated()
                && !auth.getName().equals("anonymousUser");

        return Map.of(
                "loggedIn", loggedIn
        );
    }
}
