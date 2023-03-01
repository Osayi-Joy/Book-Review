package com.osayijoy.bookreview.repository;

import com.osayijoy.bookreview.entities.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<BookReview, String> {

}
