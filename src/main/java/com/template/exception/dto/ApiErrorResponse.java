package com.template.exception.dto;

import com.template.enums.ResponseStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author diwash
 * @created 12/9/25
 */

@Data
@NoArgsConstructor
public class ApiErrorResponse {
    private ResponseStatus status;
    private int httpCode;
    private String message;
    private List<String> errors;

    public ApiErrorResponse(ResponseStatus status, final int httpCode, final String message, final String error) {
        this.status = status;
        this.httpCode = httpCode;
        this.message = message;
        errors = Collections.singletonList(error);
    }

    public ApiErrorResponse(ResponseStatus status, int httpCode, String message, List<String> errors) {
        this.status = status;
        this.httpCode = httpCode;
        this.message = message;
        this.errors = errors;
    }
}
