package com.osayijoy.bookreview.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserAlreadyExistException extends RuntimeException {
    private String message;

}
