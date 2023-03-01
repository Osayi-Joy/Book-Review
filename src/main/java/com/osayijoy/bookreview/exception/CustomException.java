package com.osayijoy.bookreview.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public CustomException( String message) {
        this.message = message;
    }
    public CustomException( String message,HttpStatus status) {
        this.status = status;
        this.message = message;
    }
}
