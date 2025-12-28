package com.template.exception.custom;

/**
 * @author diwash
 * @created 12/25/25
 */

public class EnumNotFoundException extends RuntimeException {
    public EnumNotFoundException(String message) {
        super(message);
    }
}
