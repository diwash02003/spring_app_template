package com.template.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author diwash
 * @created 12/9/25
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FieldErrorConstant {
    public static final String NOT_NULL = "notnull";
    public static final String NOT_EMPTY = "notempty";
    public static final String NOT_BLANK = "notblank";
    public static final String PATTERN = "pattern";
    public static final String SIZE = "size";
}
