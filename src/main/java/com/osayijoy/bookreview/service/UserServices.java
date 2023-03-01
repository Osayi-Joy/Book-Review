package com.osayijoy.bookreview.service;
import com.osayijoy.bookreview.DTO.request.SignupRequest;
import com.osayijoy.bookreview.DTO.request.BookReviewRequest;
import com.osayijoy.bookreview.DTO.response.UserInfoResponse;
import com.osayijoy.bookreview.DTO.response.LoginResponse;
import com.osayijoy.bookreview.DTO.response.BookReviewResponse;
import com.osayijoy.bookreview.DTO.request.LoginRequest;


public interface UserServices {

    UserInfoResponse signUp(SignupRequest signupRequest);
    LoginResponse login(LoginRequest loginRequest);
    BookReviewResponse addReview(BookReviewRequest bookReviewRequest);

    //Add Review

//    addReview(Long bookId, ReviewDto reviewDto);
//    addRating(Long bookId, RatingDto ratingDto);
//    getBooksInMyBookshelf(Long bookshelfId);



}
