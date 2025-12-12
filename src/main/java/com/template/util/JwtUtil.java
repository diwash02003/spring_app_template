package com.template.util;

import com.template.configuration.jwt.JwtService;
import com.template.constants.MessageConstants;
import com.template.constants.TokenConstants;
import com.template.exception.custom.CustomNotFoundException;
import com.template.response.CustomMessageSource;
import com.template.user.model.User;
import com.template.user.repo.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * @author diwash
 * @created 12/9/25
 */

@Component
public class JwtUtil {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final CustomMessageSource customMessageSource;

    public JwtUtil(JwtService jwtService, UserRepository userRepository, CustomMessageSource customMessageSource) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.customMessageSource = customMessageSource;
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
        return jwtService.extractAllClaims(token).get(TokenConstants.CLAIM_EMAIL, String.class);
    }

    public User getCurrentUserEntity() {
        return userRepository.findById(getCurrentUserId()).orElseThrow(() ->
                new CustomNotFoundException(customMessageSource.get(MessageConstants.NOT_FOUND,
                        customMessageSource.get(MessageConstants.USER))));
    }

    // Extract JWT from Authorization header
    public String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(TokenConstants.AUTHORIZATION_HEADER);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(TokenConstants.BEARER_PREFIX)) {
            return bearerToken.substring(TokenConstants.BEARER_PREFIX.length());
        }

        // Also check for token in cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (TokenConstants.JWT_COOKIE.equals(cookie.getName()) ||
                        TokenConstants.ACCESS_TOKEN_COOKIE.equals(cookie.getName())
                ) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}

