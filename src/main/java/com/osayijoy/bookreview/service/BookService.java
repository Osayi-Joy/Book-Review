package com.osayijoy.bookreview.service;
import jakarta.validation.Valid;
import com.osayijoy.bookreview.DTO.request.BookDTO;

public interface BookService {

    //Optional<BookListResponse> getAllBookByAuthor(Author author);
    BookDTO saveBook(@Valid BookDTO book);
    BookDTO getBookById(String id);
    BookDTO getBookByTitle(String title);
    BookDTO getBookByISBN(String ISBN);
    BookDTO updateBook(String id, BookDTO book);
    void deleteBookById(String id);

    //view reviews on a book finding by book id
    //view ratings on a book finding by book id


}
