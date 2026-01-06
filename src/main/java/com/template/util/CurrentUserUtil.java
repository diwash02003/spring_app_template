package com.template.util;

import com.template.configuration.jwt.service.JwtService;
import com.template.constants.MessageConstants;
import com.template.constants.TokenConstants;
import com.template.exception.custom.CustomNotFoundException;
import com.template.response.CustomMessageSource;
import com.template.core.user.model.User;
import com.template.core.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author diwash
 * @created 12/9/25
 */

@Component
@RequiredArgsConstructor
public class CurrentUserUtil {
    private final UserRepository userRepository;
    private final CustomMessageSource customMessageSource;
    private final JwtService jwtService;


    public Long getCurrentUserId() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) return 0L;

        Object principal = auth.getPrincipal();
        return principal instanceof Long userId ? userId : 0L;
    }

    public String getCurrentUsername() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return (auth != null && auth.isAuthenticated()) ? jwtService.extractUsername((String) auth.getCredentials()) : null;
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

}

