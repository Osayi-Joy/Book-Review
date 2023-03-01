package com.osayijoy.bookreview.entities;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "bookshelves")
public class BookShelf extends BaseEntity{
    private String userName;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "bookShelf", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public void setBooks(List<Book> booksToAdd) {
        this.books.addAll(booksToAdd);
    }
    public void setBooks(Book book) {
        this.books.add(book);
    }
}
