package com.template.exception.handler;

import com.template.response.CustomMessageSource;
import com.template.exception.dto.ApiErrorResponse;
import com.template.constants.MessageConstants;
import com.template.enums.ResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author diwash
 * @created 12/9/25
 */

@ControllerAdvice
@RequiredArgsConstructor
public class BindExceptionHandler {
    private final CustomMessageSource customMessageSource;

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<Object> handleException(BindException ex, WebRequest request) {
        final List<String> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {

            switch (Objects.requireNonNull(error.getCode())) {
                case "NotNull":
                    errors.add(customMessageSource.get("notnull", customMessageSource.get(error.getField())));
                    break;
                case "NotEmpty":
                    errors.add(customMessageSource.get("notempty", customMessageSource.get(error.getField())));
                    break;
                case "NotBlank":
                    errors.add(customMessageSource.get("notblank", customMessageSource.get(error.getField())));
                    break;
                case "Pattern":
                    errors.add(error.getDefaultMessage() != null ?
                            error.getDefaultMessage() :
                            customMessageSource.get("pattern", error.getField(), error.getRejectedValue()));
                    break;
                case "CheckUnique":
                    errors.add(error.getDefaultMessage());
                    break;
                default:
                    errors.add(error.getField() + ": " + error.getDefaultMessage());
            }
        }

        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String errorMessage = errors.size() == 1 ? errors.getFirst() : customMessageSource.get(MessageConstants.VALIDATION_ERROR);
        final ApiErrorResponse apiErrorResponse = new ApiErrorResponse(ResponseStatus.FAIL, httpStatus.value(), errorMessage, errors);
        return new ResponseEntity<>(apiErrorResponse, httpStatus);
    }
}