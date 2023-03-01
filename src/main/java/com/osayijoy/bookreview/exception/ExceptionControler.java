package com.osayijoy.bookreview.exception;

import org.springframework.http.HttpStatus;
import com.osayijoy.bookreview.DTO.response.BaseResponse;
import com.osayijoy.bookreview.util.ApiResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ExceptionControler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BookAlreadyExistException.class)
    public ResponseEntity<BaseResponse<String>> bookAlreadyExistException(BookAlreadyExistException exception){
        return ApiResponseUtil.errorResponse(HttpStatus.FORBIDDEN, exception.getMessage());
    }
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<BaseResponse<String>> bookNotFoundException(BookNotFoundException exception){
        return ApiResponseUtil.errorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<BaseResponse<String>> userNotFoundException(UserNotFoundException exception){
        return ApiResponseUtil.errorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<BaseResponse<String>> userAlreadyLikedException(UserAlreadyExistException exception){
        return ApiResponseUtil.errorResponse(HttpStatus.FORBIDDEN, exception.getMessage());
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseResponse<String>> userAlreadyLikedException(CustomException exception){
        return ApiResponseUtil.errorResponse(HttpStatus.FORBIDDEN, exception.getMessage());
    }
}
