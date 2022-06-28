package com.isaachome.book;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.isaachome.book.model.Author;
import com.isaachome.book.repo.AuthorRepo;

@Controller
public class AuthorController {

	private final AuthorRepo authorRepo;

	public AuthorController(AuthorRepo authorRepo) {
		this.authorRepo = authorRepo;
	}
	
	@QueryMapping
	public List<Author> allAuthors() {
		return authorRepo.findAll();
	}
}
