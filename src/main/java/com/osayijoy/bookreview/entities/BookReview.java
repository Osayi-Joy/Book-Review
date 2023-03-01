package com.osayijoy.bookreview.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;



@Entity
@Table(name = "bookreviews")
public class BookReview extends BaseEntity {

    private String review;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;


}
