package com.perscholas.hibernate_validation_dao.repository;

import java.util.List;

import com.perscholas.hibernate_validation_dao.models.Book;

public interface BookRepository {
	List<Book> showBooks();
	Integer insertBook(Book book);
	Boolean removeBook(Integer bookId);
}
