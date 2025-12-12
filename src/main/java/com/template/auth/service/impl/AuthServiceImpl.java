package com.template.auth.service.impl;

import com.template.auth.dto.AuthenticationRequest;
import com.template.auth.dto.AuthenticationResponse;
import com.template.auth.dto.ChangePasswordRequest;
import com.template.auth.service.AuthService;
import com.template.configuration.jwt.JwtService;
import com.template.constants.MessageConstants;
import com.template.exception.custom.CustomNotFoundException;
import com.template.exception.custom.InvalidCurrentPasswordException;
import com.template.exception.custom.PasswordMismatchException;
import com.template.response.CustomMessageSource;
import com.template.user.model.User;
import com.template.user.repo.UserRepository;
import com.template.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    private final JwtUtil jwtUtil;
    private final CustomMessageSource customMessageSource;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response) {
        // 1. Authenticate using Spring Security
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsernameOrEmail(), request.getPassword()));
        // 2. Fetch full User entity from DB
        User user = findUserByUserNameOrEmail(request.getUsernameOrEmail(), request.getUsernameOrEmail());
        // 3. Generate JWT with all claims
        String accessToken = jwtTokenProvider.generateToken(user, user.getId(), user.getEmail());

        return new AuthenticationResponse(accessToken, accessToken, user.getUsername(), user.getEmail());
    }

    @Override
    public void changePassword(ChangePasswordRequest request) {
        User user = jwtUtil.getCurrentUserEntity();
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

    private User findUserByUserNameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username, email).orElseThrow(() ->
                new CustomNotFoundException(customMessageSource.get(MessageConstants.NOT_FOUND,
                        customMessageSource.get(MessageConstants.USER))));
    }
}
