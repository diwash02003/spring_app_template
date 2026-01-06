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
    public static final String LOGOUT = "logout";

    public static final String SUCCESS = "success";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String INVALID_CURRENT_PASSWORD = "password.change.invalid.current";
    public static final String PASSWORDS_DO_NOT_MATCH = "password.change.mismatch";
    public static final String COUNTRY = "country";
    public static final String PROVINCE = "province";
    public static final String DISTRICT = "district";
    public static final String LOCAL_BODY = "local.body";
    public static final String ENUM = "enum";
    public static final String ROLE = "role";
    public static final String ASSOCIATION = "association";
}
