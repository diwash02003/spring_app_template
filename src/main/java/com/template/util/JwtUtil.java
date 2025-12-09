package com.template.util;

import com.template.configuration.jwt.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * @author diwash
 * @created 12/9/25
 */

@Component
public class JwtUtil {

    private final JwtService jwtService;

    public JwtUtil(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public Long getCurrentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return 0L;
        }

        Object credentials = auth.getCredentials();
        if (!(credentials instanceof String token)) {
            return 0L;
        }

        return jwtService.extractUserId(token);
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }

        return auth.getName();
    }

    public String getCurrentEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return null;
        }

        String token = (String) auth.getCredentials();
        return jwtService.extractAllClaims(token).get("email", String.class);
    }
}

