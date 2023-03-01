package com.osayijoy.bookreview.service.implementation;

import com.osayijoy.bookreview.repository.UserRepository;
import com.osayijoy.bookreview.service.UserServices;
import com.osayijoy.bookreview.DTO.response.UserInfoResponse;
import com.osayijoy.bookreview.DTO.request.SignupRequest;
import com.osayijoy.bookreview.exception.CustomException;
import com.osayijoy.bookreview.util.EmailValidatorService;
import com.osayijoy.bookreview.entities.User;
import com.osayijoy.bookreview.DTO.request.LoginRequest;
import com.osayijoy.bookreview.DTO.response.LoginResponse;
import com.osayijoy.bookreview.DTO.response.BookReviewResponse;
import com.osayijoy.bookreview.DTO.request.BookReviewRequest;
import com.osayijoy.bookreview.enums.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Objects;


@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserServices {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserInfoResponse signUp(SignupRequest signUpDto) {
        if ("".equals(signUpDto.getEmail().trim())) {
            throw new CustomException("Email can not be empty");
        }
        String email = signUpDto.getEmail().toLowerCase();
        if(!EmailValidatorService.isValid(email)){
            throw new CustomException("Enter a valid email address");
        }
        if (Objects.nonNull(userRepository.findByEmail(email))) {
            throw new CustomException("User already exist");
        }
        User student = User.builder()
                .firstName(signUpDto.getFirstName())
                .lastName(signUpDto.getLastName())
                .username(signUpDto.getUsername())
                .email(email)
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .phoneNumber(signUpDto.getPhoneNumber())
                .gender(signUpDto.getGender())
                .about(signUpDto.getAbout())
                .profilePicture(signUpDto.getProfilePicture())
                .role(UserRole.ROLE_USER)
                .build();
        userRepository.save(student);
        return new UserInfoResponse();
    }

    @Override
    public LoginResponse login(LoginRequest loginDTO) {
//        return authenticateService.getLoginResponse(loginDTO, authenticationManager, jwtService, ROLE_USER);
        return new LoginResponse();
    }

    @Override
    public BookReviewResponse addReview(BookReviewRequest bookReviewRequest) {
//        var user = userRepository.findByEmail(authenticateService.loadUserByUsername(bookReviewRequest.getUsername()).getUsername());
//        return  new ModelMapper().map(bookReviewRequest, BookReviewResponse.class);
        return new BookReviewResponse();
    }


}
