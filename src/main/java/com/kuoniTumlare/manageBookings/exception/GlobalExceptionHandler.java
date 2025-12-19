package com.kuoniTumlare.manageBookings.exception;

import com.kuoniTumlare.manageBookings.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidation(ValidationException ex) {
        ApiResponse<Object> response = new ApiResponse<>(
                ex.getStatus(),
                ex.getMessage(),
                null
        );
        return ResponseEntity.status(ex.getStatus()).body(response);
    }
}