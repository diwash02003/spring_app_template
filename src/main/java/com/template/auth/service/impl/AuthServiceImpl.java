package com.template.auth.service.impl;

import com.template.configuration.jwt.JwtService;
import com.template.auth.dto.AuthenticationRequest;
import com.template.auth.dto.AuthenticationResponse;
import com.template.auth.service.AuthService;
import com.template.user.model.User;
import com.template.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // 1. Authenticate using Spring Security
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsernameOrEmail(), request.getPassword()));
        // 2. Fetch full User entity from DB
        User user = userRepository.findByUsernameOrEmail(request.getUsernameOrEmail(), request.getUsernameOrEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // 3. Generate JWT with all claims
        String jwt = jwtTokenProvider.generateToken(user, user.getId(), user.getEmail());
        return new AuthenticationResponse(jwt);
    }
}
