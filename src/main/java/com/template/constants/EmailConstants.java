package com.template.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author diwash
 * @created 12/9/25
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailConstants {
    public static final String SUBJECT = "Subject";
    public static final String USER_REGISTER = "Your Account is Created";
    public static final String RESET_PASSWORD = "Your Password is Reset Successfully";
    public static final String SUPPORT_EMAIL = "dpokhrel111@gmail.com";
    public static final String SUPPORT_PHONE_NUMBER = "9800000000";
    public static final String REDIRECT_URL = "localhost:4000/auth/login";
}
