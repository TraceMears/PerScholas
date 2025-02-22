package com.perscholas.hibernate_validation_dao.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import com.perscholas.hibernate_validation_dao.models.Book;
import com.perscholas.hibernate_validation_dao.repository.BookRepository;

@Repository("mariaDbBookRepository")
public class MariaDbBookRepository implements BookRepository {

	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	private final class BookMapper implements RowMapper<Book> {
		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book book = new Book();
			book.setBookId(rs.getInt(1));
			book.setTitle(rs.getString(2));
			book.setAuthor(rs.getString(3));
			return book;
		}
	}
	
	@Override
	public List<Book> showBooks() {
		String selectBooks = "SELECT * FROM books";
		List<Book> result = mariaDbJdbcTemplate.query(selectBooks, 
				new BookMapper());
		return result;
	}	
	
	@Override
	public Integer insertBook(Book book) {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("title", book.getTitle());
		params.addValue("author", book.getAuthor());
		String createBookSql = "insert into books (title, author) values "
				+ "(:title,:author)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createBookSql, 
				params, keyHolder);
		if (createResult > 0) {
			id = keyHolder.getKey().intValue();
		}
		return id;
	}
	
//	@Override
//	public Student getStudentById(Integer id) {
//		String selectStudentsById = "select * from students where student_id = :id";
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("id", id);
//		Student student = null;
//		try
//		{
//			student = (Student)hsqldbJdbcTemplate.queryForObject(
//					selectStudentsById, params, new StudentMapper());
//		}
//		catch (EmptyResultDataAccessException e)
//		{
//			e.getMessage();
//		}
//		return student;
//	}
//	
//	@Override
//	public Boolean updateStudent(Student student) {
//		Integer result;
//		Map<String, Object> params = new HashMap<>();
//		params.put("name", student.getName());
//		params.put("email", student.getEmail());
//		params.put("id", student.getStudentId());
//		String updateSql = "update students set name = :name, email = :email "
//				+ "where student_id = :id";
//		result = hsqldbJdbcTemplate.update(updateSql, params);
//		if (result > 0) {
//			return true;
//		}
//		return false;
//	}
	
	@Override
	public Boolean removeBook(Integer bookId) {
		Integer result;
		String deleteSql = "delete from books where book_id = :book_id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("book_id", bookId);
		result = mariaDbJdbcTemplate.update(deleteSql, params);
		if (result > 0) {
			return true;
		}
		return false;
	}
}
