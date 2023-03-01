package com.osayijoy.bookreview.service;

public interface BookShelfService {
    String createBookshelf(String userId);
    String addBookToUserBookshelf(String userId, String bookId);
    String removeBookFromUserBookshelf(String userId, String bookId);
}
