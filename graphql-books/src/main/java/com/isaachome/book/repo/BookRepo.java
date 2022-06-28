package com.isaachome.book.repo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.isaachome.book.model.Book;
import com.isaachome.book.model.Rating;

@Repository
public class BookRepo {

	  private final AuthorRepo authorRepo ;
	    private List<Book> books = new ArrayList<>();

	    public BookRepo(AuthorRepo authorRepo) {
	        this.authorRepo = authorRepo;
	    }

	    public List<Book> findAll() {
	        return books;
	    }

	    public Book findOne(Integer id) {
	        return books.stream().filter(book -> book.id() == id).findFirst().orElseThrow(() -> new RuntimeException("Book not found"));
	    }

	    @PostConstruct
	    private void init() {
	        books.add(new Book(1,"Reactive Spring", 484, Rating.FIVE_STARS, authorRepo.findByName("Josh Long")));
	        books.add(new Book(2,"Spring Boot Up & Running", 328, Rating.FIVE_STARS, authorRepo.findByName("Mark Heckler")));
	        books.add(new Book(3,"Hacking with Spring Boot 2.3", 392, Rating.FIVE_STARS, authorRepo.findByName("Greg Turnquist")));
	    }
}
