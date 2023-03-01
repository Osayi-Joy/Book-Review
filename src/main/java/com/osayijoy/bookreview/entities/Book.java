package com.osayijoy.bookreview.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Book extends BaseEntity {
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "ISBN", nullable = false)
    private String ISBN;
    @Column(name = "description", nullable = false)
    private String description;
    private int ratingCount;
    private int reviewCount;
    private String author;
    private String aboutAuthor;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookReview> bookReviews;
    @ManyToOne
    @JoinColumn(name = "bookshelfId", referencedColumnName = "id", nullable = false)
    private BookShelf bookShelf;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings;

//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name = "userId", referencedColumnName = "id")
//    private User user;
}
