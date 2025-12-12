package com.template.exception.handler;

import com.template.enums.ResponseStatus;
import com.template.exception.custom.CustomNotFoundException;
import com.template.exception.custom.InvalidCurrentPasswordException;
import com.template.exception.custom.PasswordMismatchException;
import com.template.exception.custom.ResourceNotFoundException;
import com.template.exception.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author diwash
 * @created 12/9/25
 */


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleCustomNotFoundException(CustomNotFoundException ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                ResponseStatus.FAIL,
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(InvalidCurrentPasswordException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidCurrentPassword(InvalidCurrentPasswordException ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                ResponseStatus.FAIL,
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Current Password",
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<ApiErrorResponse> handlePasswordMismatch(PasswordMismatchException ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                ResponseStatus.FAIL,
                HttpStatus.BAD_REQUEST.value(),
                "Password Mismatch",
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // 404 for REST endpoints (fallback controller will throw this)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                ResponseStatus.FAIL,
                HttpStatus.NOT_FOUND.value(),
                "Resource Not Found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    // Generic exceptions → 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(Exception ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                ResponseStatus.FAIL,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}


