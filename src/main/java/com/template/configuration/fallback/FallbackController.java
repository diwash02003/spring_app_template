package com.template.configuration.fallback;

import com.template.exception.dto.ApiErrorResponse;
import com.template.enums.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author diwash
 * @created 12/9/25
 */

@RestController
public class FallbackController {

    @RequestMapping("/**")
    public ResponseEntity<ApiErrorResponse> handleNotFound() {
        ApiErrorResponse error = new ApiErrorResponse(
                ResponseStatus.FAIL,
                HttpStatus.NOT_FOUND.value(),
                "Endpoint Not Found",
                "The requested endpoint does not exist"
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
