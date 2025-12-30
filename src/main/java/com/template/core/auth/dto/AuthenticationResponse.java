package com.template.core.auth.dto;

import lombok.*;

/**
 * @author diwash
 * @created 12/9/25
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    private String accessToken;
    private String refreshToken;
    private String username;
    private String email;
}
