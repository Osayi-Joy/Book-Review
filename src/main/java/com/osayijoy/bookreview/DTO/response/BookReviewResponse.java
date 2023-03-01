package com.osayijoy.bookreview.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BookReviewResponse {
    private String bookReview;
    private String username;
    private String bookName;

}
