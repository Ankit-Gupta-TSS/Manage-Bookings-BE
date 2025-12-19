package com.kuoniTumlare.manageBookings.exception;

import com.kuoniTumlare.manageBookings.response.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public Mono<ApiResponse<Object>> handleValidation(ValidationException ex) {
        return Mono.just(
                ApiResponse.error(ex.getStatus(), ex.getMessage())
        );
    }
}