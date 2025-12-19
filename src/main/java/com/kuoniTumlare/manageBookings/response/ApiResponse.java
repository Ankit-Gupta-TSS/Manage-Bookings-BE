package com.kuoniTumlare.manageBookings.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private String message;
    private T data;

    public ApiResponse() {
        this.status = 200;
        this.message = "Request completed successfully";
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> builder() {
        return new ApiResponse<>();
    }

    public ApiResponse<T> status(int status) {
        this.status = status;
        return this;
    }

    public ApiResponse<T> message(String message) {
        this.message = message;
        return this;
    }

    public ApiResponse<T> data(T data) {
        this.data = data;
        return this;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}
