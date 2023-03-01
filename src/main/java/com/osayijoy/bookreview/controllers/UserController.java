package com.osayijoy.bookreview.controllers;

import com.osayijoy.bookreview.service.UserServices;
import com.osayijoy.bookreview.DTO.request.SignupRequest;
import com.osayijoy.bookreview.DTO.request.LoginRequest;
import com.osayijoy.bookreview.DTO.response.BaseResponse;
import com.osayijoy.bookreview.DTO.response.LoginResponse;
import com.osayijoy.bookreview.util.ErrorsMap;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping(value="/api/book-review")
public class UserController {
    private final UserServices userService;


    @Operation(summary = "Register User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User registered successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SignupRequest.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid user details",
                    content = @Content)})
    @PostMapping("/user-sign-up")
    public ResponseEntity<BaseResponse<?>> signUp(@RequestBody @Valid SignupRequest signUpDto, BindingResult result){
        Map<String, String> errorsMap = ErrorsMap.getErrors(result);
        if(errorsMap != null){
            return new ResponseEntity<>(new BaseResponse<>(errorsMap, "Details supplied is not valid"), HttpStatus.BAD_REQUEST);
        }
        try {
            return new ResponseEntity<>(new BaseResponse<>(userService.signUp(signUpDto), "Success"), CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new BaseResponse<>(null, ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user-log-in")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest loginDTO){
        try {
            LoginResponse response = userService.login(loginDTO);
            return ResponseEntity.ok(new BaseResponse<>(response, "success"));
        } catch (Exception ex) {
            return new ResponseEntity<>(new BaseResponse<>(null, ex.getMessage()), BAD_REQUEST);
        }
    }









}
