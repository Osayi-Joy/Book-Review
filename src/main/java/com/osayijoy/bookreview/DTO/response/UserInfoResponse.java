package com.osayijoy.bookreview.DTO.response;

import com.osayijoy.bookreview.enums.Gender;
import com.osayijoy.bookreview.enums.UserRole;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class UserInfoResponse {
	private String Id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String phoneNumber;
	private Gender gender;
	private String about;
	private String profilePicture;
	private UserRole role;


}
