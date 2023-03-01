package com.osayijoy.bookreview.DTO.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseResponse<T> {
    private HttpStatus status;
    private T data;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();

    public BaseResponse(HttpStatus status) {
        this.status = status;
    }

    public BaseResponse(T data, String message) {
        this.data = data;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
