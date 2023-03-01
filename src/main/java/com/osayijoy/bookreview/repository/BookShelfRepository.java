package com.osayijoy.bookreview.repository;

import com.osayijoy.bookreview.entities.BookShelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookShelfRepository extends JpaRepository<BookShelf, String> {
    BookShelf findByUserName(String userName);
}
