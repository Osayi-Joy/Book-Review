package com.osayijoy.bookreview.service.implementation;

import com.osayijoy.bookreview.exception.BookAlreadyExistException;
import com.osayijoy.bookreview.repository.BookRepository;

import com.osayijoy.bookreview.DTO.request.BookDTO;

import com.osayijoy.bookreview.entities.Book;

import com.osayijoy.bookreview.exception.BookNotFoundException;
import com.osayijoy.bookreview.service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookServiceImplementation implements BookService {
    private BookRepository bookRepository;

    @Override
    public BookDTO saveBook(BookDTO book) throws BookAlreadyExistException {
        Book existingBook = bookRepository.findBookByTitle(book.getTitle());
        if (existingBook != null) {
            throw new BookAlreadyExistException("Book Already exist");
        }else{
            Book newBook = new Book();
            newBook.setTitle(book.getTitle());
            newBook.setISBN(book.getISBN());
            newBook.setAuthor(book.getAuthor());
            newBook.setDescription(book.getDescription());
            return new BookDTO(newBook.getTitle(), newBook.getISBN(), newBook.getAuthor(), newBook.getDescription());
        }
    }

    @Override
    public BookDTO getBookById(String id) {
        Book foundBook = bookRepository.findById(id).orElse(null);
        if (foundBook != null) {
            return new BookDTO(foundBook.getTitle(), foundBook.getISBN(), foundBook.getAuthor(), foundBook.getDescription());
        } else {
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public BookDTO getBookByTitle(String title) {
        Book foundBook = bookRepository.findBookByTitle(title);
        if (foundBook != null) {
            return new BookDTO(foundBook.getTitle(), foundBook.getISBN(), foundBook.getAuthor(), foundBook.getDescription());
        } else {
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public BookDTO getBookByISBN(String ISBN) {
        Book foundBook = bookRepository.findBookByISBN(ISBN);
        if (foundBook != null) {
            return new BookDTO(foundBook.getTitle(), foundBook.getISBN(), foundBook.getAuthor(), foundBook.getDescription());
        } else {
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public BookDTO updateBook(String id, BookDTO book) {
        Book foundBook = bookRepository.findById(id).orElse(null);
        if(foundBook != null){
            foundBook.setTitle(book.getTitle());
            foundBook.setISBN(book.getISBN());
            foundBook.setAuthor(book.getAuthor());
            foundBook.setDescription(book.getDescription());
            bookRepository.save(foundBook);
            return new BookDTO(foundBook.getTitle(), foundBook.getISBN(), foundBook.getAuthor(), foundBook.getDescription());
        }else{
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }
}
