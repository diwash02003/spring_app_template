package com.template.exception.custom;

/**
 * @author diwash
 * @created 12/9/25
 */

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
