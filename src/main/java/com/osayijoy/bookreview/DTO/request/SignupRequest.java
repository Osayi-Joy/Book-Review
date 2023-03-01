package com.osayijoy.bookreview.DTO.request;

import com.osayijoy.bookreview.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignupRequest {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String username;
    @NonNull
    @Size(min = 5)
    private String email;
    @NonNull
    @Size(min = 3)
    private String password;
    private String phoneNumber;
    private Gender gender;
    private String about;
    private String profilePicture;
  

}
