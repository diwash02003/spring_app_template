package com.template.auth.controller;

import com.template.response.MessageParameter;
import com.template.constants.MessageConstants;
import com.template.auth.dto.AuthenticationRequest;
import com.template.auth.dto.AuthenticationResponse;
import com.template.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author diwash
 * @created 12/9/25
 */

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @MessageParameter(message = MessageConstants.SUCCESS, source = MessageConstants.LOGIN)
    public AuthenticationResponse login(@RequestBody @Valid AuthenticationRequest request) {
        return authService.authenticate(request);
    }
}