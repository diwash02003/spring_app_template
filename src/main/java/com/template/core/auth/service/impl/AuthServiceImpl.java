package com.template.core.auth.service.impl;

import com.template.configuration.jwt.service.JwtService;
import com.template.configuration.security.user.CustomUserDetails;
import com.template.constants.MessageConstants;
import com.template.core.auth.dto.AuthenticationRequest;
import com.template.core.auth.dto.AuthenticationResponse;
import com.template.core.auth.dto.ChangePasswordRequest;
import com.template.core.auth.service.AuthService;
import com.template.core.user.model.User;
import com.template.core.user.repo.UserRepository;
import com.template.exception.custom.InvalidCurrentPasswordException;
import com.template.exception.custom.PasswordMismatchException;
import com.template.response.CustomMessageSource;
import com.template.util.CurrentUserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author diwash
 * @created 12/9/25
 */

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtTokenProvider;
    private final UserRepository userRepository;
    private final CustomMessageSource customMessageSource;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUserUtil currentUserUtil;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

        assert user != null;
        String accessToken = jwtTokenProvider.generateToken(user);
        return new AuthenticationResponse(accessToken, accessToken, user.getUsername(), user.getEmail());
    }

    @Override
    public void changePassword(ChangePasswordRequest request) {
        User user = currentUserUtil.getCurrentUserEntity();
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new InvalidCurrentPasswordException(
                    customMessageSource.get(MessageConstants.INVALID_CURRENT_PASSWORD,
                            customMessageSource.get(MessageConstants.PASSWORD))
            );
        }

        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new PasswordMismatchException(
                    customMessageSource.get(MessageConstants.PASSWORDS_DO_NOT_MATCH,
                            customMessageSource.get(MessageConstants.PASSWORD))
            );
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }
}
