package com.template.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author diwash
 * @created 12/9/25
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageConstants {
    public static final String SUCCESS_CREATE = "success.create";
    public static final String SUCCESS_FETCH = "success.fetch";
    public static final String SUCCESS_UPDATE = "success.update";
    public static final String SUCCESS_DELETE = "success.delete";

    public static final String NOT_FOUND = "not.found";
    public static final String DUPLICATE_FOUND = "duplicate.found";
    public static final String ALREADY_EXIST = "violated.unique.constraint";
    public static final String VIOLATED_FOREIGN_CONSTRAINTS = "violated.foreign.constraint";
    public static final String UNAUTHORIZED = "unauthorized";
    public static final String FORBIDDEN = "forbidden";
    public static final String VALIDATION_ERROR = "validation.error";
    public static final String LOGIN = "login";
    public static final String SUCCESS = "success";

}
