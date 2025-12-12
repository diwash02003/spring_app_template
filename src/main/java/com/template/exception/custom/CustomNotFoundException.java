package com.template.exception.custom;

/**
 * @author diwash
 * @created 12/10/25
 */

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String message) {
        super(message);
    }
}
