package com.template.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author diwash
 * @created 12/25/25
 */

@Getter
@AllArgsConstructor
public enum UserType {
    SUPER_ADMIN(0, "Super Admin");

    private final Integer key;
    private final String value;
}
