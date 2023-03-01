package com.osayijoy.bookreview.repository;
import com.osayijoy.bookreview.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
    Book findBookByAuthor(String author);
    Book findBookByTitle(String title);
    Book findBookByISBN(String ISBN);
}
