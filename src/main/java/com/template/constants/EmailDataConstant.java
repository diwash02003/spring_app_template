package com.template.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author diwash
 * @created 12/9/25
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailDataConstant {
    public static final String HOST = "smtp.gmail.com";
    public static final Integer PORT = 587;

    /**
     * Your Gmail address for sending emails
     * TODO: Replace with actual email or use environment variable
     */
    public static final String SENDER_EMAIL = "your.email@gmail.com"; // TODO : UPDATE

    /**
     * Gmail App Password (NOT your regular password)
     * How to get:
     * 1. Enable 2-Step Verification on Google Account
     * 2. Go to: https://myaccount.google.com/apppasswords
     * 3. Select "Mail" → "Other" → Name it → Generate
     * 4. Use 16-char password WITHOUT spaces
     * TODO: Replace with actual app password or use environment variable
     */
    public static final String EMAIL_PASSWORD = "abcd abcd abcd abcd"; // TODO : UPDATE

    public static final String PROTOCOL_KEY = "mail.transport.protocol";
    public static final String PROTOCOL_VALUE = "smtp";

    public static final String SMTP_AUTH_KEY = "mail.smtp.auth";
    public static final String SMTP_AUTH_VALUE = "true";

    public static final String SMTP_STARTTLS_KEY = "mail.smtp.starttls.enable";
    public static final String SMTP_STARTTLS_VALUE = "true";

    public static final String SMTP_SSL_KEY = "mail.smtp.ssl.enable";
    public static final String SMTP_SSL_VALUE = "false";

    public static final String MAIL_DEBUG_KEY = "mail.debug";
    public static final String MAIL_DEBUG_VALUE = "true";
}
