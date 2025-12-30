package com.template.configuration.security.handler;

import com.template.constants.MessageConstants;
import com.template.exception.dto.ApiErrorResponse;
import com.template.enums.ResponseStatus;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author diwash
 * @created 12/9/25
 */

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(@NonNull HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        ApiErrorResponse errorResponse = new ApiErrorResponse(ResponseStatus.FAIL, HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage(), MessageConstants.FORBIDDEN);
        String json = new ObjectMapper().writeValueAsString(errorResponse);
        response.getWriter().write(json);
    }
}
