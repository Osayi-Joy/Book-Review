package com.osayijoy.bookreview.DTO.response;

import com.osayijoy.bookreview.enums.Gender;
import com.osayijoy.bookreview.enums.UserRole;
import lombok.*;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String userId;
    private String token;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Gender gender;
    private String about;
    private String profilePicture;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
