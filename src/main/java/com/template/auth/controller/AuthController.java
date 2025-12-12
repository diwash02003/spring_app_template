package com.template.auth.controller;

import com.template.auth.dto.AuthenticationRequest;
import com.template.auth.dto.AuthenticationResponse;
import com.template.auth.dto.ChangePasswordRequest;
import com.template.auth.service.AuthService;
import com.template.constants.MessageConstants;
import com.template.response.MessageParameter;
import jakarta.servlet.http.HttpServletResponse;
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
    public AuthenticationResponse login(@RequestBody @Valid AuthenticationRequest request, HttpServletResponse response) {
        return authService.authenticate(request, response);
    }

    @PostMapping("/change-password")
    @MessageParameter(message = MessageConstants.SUCCESS_UPDATE, source = MessageConstants.PASSWORD)
    public void changePassword(@RequestBody @Valid ChangePasswordRequest changePasswordRequest) {
        authService.changePassword(changePasswordRequest);
    }
}