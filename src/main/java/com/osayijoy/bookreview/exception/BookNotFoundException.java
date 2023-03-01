package com.osayijoy.bookreview.exception;

public class BookNotFoundException extends RuntimeException{
    private String message;

    public BookNotFoundException(String message) {
        this.message = message;
    }
}
