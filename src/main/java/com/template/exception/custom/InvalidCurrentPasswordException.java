package com.template.exception.custom;

/**
 * @author diwash
 * @created 12/10/25
 */

public class InvalidCurrentPasswordException extends RuntimeException {
    public InvalidCurrentPasswordException(String message) {
        super(message);
    }
}
