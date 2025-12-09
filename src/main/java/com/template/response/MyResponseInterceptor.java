package com.template.response;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @author diwash
 * @created 12/9/25
 */

@RestControllerAdvice
@RequiredArgsConstructor
public class MyResponseInterceptor implements ResponseBodyAdvice<Object> {
    private final CustomMessageSource customMessageSource;

    @Override
    public boolean supports(MethodParameter returnType,@NonNull Class converterType) {
        Method method = returnType.getMethod();
        return method.isAnnotationPresent(MessageParameter.class);
    }

    @Override
    public @Nullable Object beforeBodyWrite(@Nullable Object body,
                                            MethodParameter returnType,
                                            @NonNull MediaType selectedContentType,
                                            @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                            @NonNull ServerHttpRequest request,
                                            @NonNull ServerHttpResponse response) {

        Method method = (Method) returnType.getMember();
        if (method.isAnnotationPresent(MessageParameter.class)) {
            MessageParameter annotation = method.getAnnotation(MessageParameter.class);
            String message = annotation.message();
            String[] sources = annotation.source();
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setData(body);
            apiResponse.setMessage(buildMessage(message, sources));
            return apiResponse;
        }
        return null;
    }

    private String buildMessage(String message, String... sources) {
        return switch (sources.length) {
            case 2 -> customMessageSource.get(message,
                    customMessageSource.get(sources[0]),
                    customMessageSource.get(sources[1]));
            case 3 -> customMessageSource.get(message,
                    customMessageSource.get(sources[0]),
                    customMessageSource.get(sources[1]),
                    customMessageSource.get(sources[2]));
            case 4 -> customMessageSource.get(message,
                    customMessageSource.get(sources[0]),
                    customMessageSource.get(sources[1]),
                    customMessageSource.get(sources[2]),
                    customMessageSource.get(sources[3]));
            default -> customMessageSource.get(message,
                    customMessageSource.get(sources[0]));
        };
    }
}


