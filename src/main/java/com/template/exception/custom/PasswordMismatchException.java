package com.template.exception.custom;

/**
 * @author diwash
 * @created 12/10/25
 */

public class PasswordMismatchException extends RuntimeException {
    public PasswordMismatchException(String message) {
        super(message);
    }
}
