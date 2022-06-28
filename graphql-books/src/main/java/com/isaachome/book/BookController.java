package com.isaachome.book;
import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.isaachome.book.model.Book;
import com.isaachome.book.repo.BookRepo;

@Controller
public class BookController {

	private final BookRepo bookRepo;

	public BookController(BookRepo bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@SchemaMapping(typeName = "Query", value = "allBooks")
	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	@QueryMapping
	public Book findOne(@Argument Integer id) {
		return bookRepo.findOne(id);
	}
}
