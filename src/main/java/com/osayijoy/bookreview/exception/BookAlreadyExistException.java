package com.osayijoy.bookreview.exception;

public class BookAlreadyExistException extends RuntimeException{
    private String message;

    public BookAlreadyExistException(String message) {
        this.message = message;
    }
}
