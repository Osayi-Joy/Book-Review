package com.osayijoy.bookreview.service.implementation;

import com.osayijoy.bookreview.exception.CustomException;
import com.osayijoy.bookreview.exception.UserNotFoundException;
import com.osayijoy.bookreview.repository.BookRepository;
import com.osayijoy.bookreview.repository.BookShelfRepository;
import com.osayijoy.bookreview.repository.UserRepository;
import com.osayijoy.bookreview.service.BookShelfService;
import com.osayijoy.bookreview.entities.BookShelf;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class BookShelfServiceImplementation implements BookShelfService {
    private final BookShelfRepository bookShelfRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    @Override
    public String createBookshelf(String userId) {
        var user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        var bookshelf = bookShelfRepository.findByUserName(user.get().getUsername());
         if (bookshelf != null) {
            throw new CustomException("Bookshelf already exists");
         }else {
            BookShelf bookShelf = new BookShelf();
            bookShelf.setUser(user.get());
            bookShelf.setUserName(user.get().getUsername());
            user.get().setBookShelf(bookShelf);
            userRepository.save(user.get());
            bookShelfRepository.save(bookShelf);
            return "Bookshelf created";
        }
    }


    @Override
    public String addBookToUserBookshelf(String userId, String bookId) {
        var user = userRepository.findById(userId).orElse(null);
        var book = bookRepository.findById(bookId).orElse(null);
        if (user == null || book == null) {
            throw new CustomException("User or Book not found");
        }
        var bookshelf = bookShelfRepository.findByUserName(user.getUsername());
        if (bookshelf == null) {
            throw new CustomException("Bookshelf does not exist");
        }else {
           bookshelf.setBooks(book);
        }
        return "Book added to bookshelf";
    }



    @Override
    public String removeBookFromUserBookshelf(String userId, String bookId) {
        return null;
    }
}
