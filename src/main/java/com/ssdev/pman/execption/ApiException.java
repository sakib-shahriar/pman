package com.ssdev.pman.execption;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
