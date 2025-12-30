package com.template.core.auth.service;

import com.template.core.auth.dto.AuthenticationRequest;
import com.template.core.auth.dto.AuthenticationResponse;
import com.template.core.auth.dto.ChangePasswordRequest;

/**
 * @author diwash
 * @created 12/9/25
 */

public interface AuthService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    void changePassword(ChangePasswordRequest changePasswordRequest);

}
