package com.osayijoy.bookreview.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "ratings")
public class Rating extends BaseEntity{

    @Column(nullable = false)
    private int score;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private Book book;
}
