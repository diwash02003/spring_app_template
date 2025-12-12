package com.template.auth.service;

import com.template.auth.dto.AuthenticationRequest;
import com.template.auth.dto.AuthenticationResponse;
import com.template.auth.dto.ChangePasswordRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author diwash
 * @created 12/9/25
 */

public interface AuthService {
    AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response);

    void changePassword(ChangePasswordRequest changePasswordRequest);

}
