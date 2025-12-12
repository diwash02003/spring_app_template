package com.template.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author diwash
 * @created 12/10/25
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenConstants {
    // HTTP Headers
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";

    // Cookie Names
    public static final String ACCESS_TOKEN_COOKIE = "access_token";
    public static final String REFRESH_TOKEN_COOKIE = "refresh_token";
    public static final String JWT_COOKIE = "jwt";

    // Token Types
    public static final String TOKEN_TYPE_ACCESS = "access";
    public static final String TOKEN_TYPE_REFRESH = "refresh";
    public static final String TOKEN_TYPE_RESET = "password_reset";

    // Token Claims
    public static final String CLAIM_USER_ID = "userId";
    public static final String CLAIM_EMAIL = "email";
    public static final String CLAIM_AUTHORITIES = "authorities";
    public static final String CLAIM_TOKEN_TYPE = "type";
}
