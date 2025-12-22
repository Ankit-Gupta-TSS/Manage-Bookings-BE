package com.kuoniTumlare.manageBookings.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {

    private final int status;

    public ValidationException(String message) {
        super(message);
        this.status = 400;
    }

    public ValidationException(int status, String message) {
        super(message);
        this.status = status;
    }

}

