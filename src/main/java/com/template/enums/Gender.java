package com.template.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author diwash
 * @created 12/25/25
 */

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("MALE", "Male"),
    FEMALE("FEMALE", "Female"),
    OTHERS("OTHERS", "Others");

    private final String key;
    private final String value;
}