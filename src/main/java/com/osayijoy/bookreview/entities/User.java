package com.osayijoy.bookreview.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.osayijoy.bookreview.enums.Gender;
import com.osayijoy.bookreview.enums.Provider;
import com.osayijoy.bookreview.enums.UserRole;
import jakarta.persistence.*;

import lombok.*;
import java.util.List;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User extends BaseEntity {

	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String phoneNumber;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String about;
	private String profilePicture;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@Enumerated(EnumType.STRING)
	private Provider provider;

	@OneToOne(mappedBy = "user")
	private BookShelf bookShelf;
	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookReview> bookReviews;
	@OneToOne(mappedBy = "user")
	private Rating rating;

	public BookShelf getBookShelf() {
		return bookShelf;
	}

	public void setBookShelf(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
	}
}
