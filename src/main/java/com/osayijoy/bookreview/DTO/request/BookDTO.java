package com.osayijoy.bookreview.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookDTO {
    private String title;
    private String author;
    private String ISBN;
    private String description;

}
