package com.book.catalogue.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.book.catalogue.exception.BookException;
import com.book.catalogue.exception.BookNotFoundException;
import com.book.catalogue.model.AuthorBean;
import com.book.catalogue.model.BookBean;
import com.book.catalogue.service.BookService;

public class BookRestControllerTest {
	
	private BookRestController bookRestController;
	private BookService bookService;
	
	@Before
	public void before() {
		bookRestController = new BookRestController();
		bookService = mock(BookService.class);
		ReflectionTestUtils.setField(bookRestController, "bookService", bookService);
	}
	
	@Test
	public void testCreateOrUpdate() {
		BookBean book  = new BookBean();
		book.setId(1001l);
		book.setBookName("2 States")
			.setBookDesc("Love Story")
			.setAuthor(new AuthorBean(1001l, "Chetan", "Bhagat"));
		
		when(bookService.createBook(book)).thenReturn(book);
		
		ResponseEntity<BookBean> res = bookRestController.createOrUpdateBook(book);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(1001l, res.getBody().getId());
	}
	
	//exception handling with annotation
	@Test(expected = BookException.class)
	public void testCreateOrUpdateForEmptyBookName() {
		BookBean book  = new BookBean();
		book.setId(1001l);
		book.setBookName("")
			.setBookDesc("Love Story")
			.setAuthor(new AuthorBean(1001l, "Chetan", "Bhagat"));
		
		when(bookService.createBook(book)).thenReturn(book);
		
		bookRestController.createOrUpdateBook(book);
	}
	
	@Test
	public void testGetBook() {
		BookBean book  = new BookBean();
		book.setId(1001l);
		book.setBookName("2 States")
			.setBookDesc("Love Story")
			.setAuthor(new AuthorBean(1001l, "Chetan", "Bhagat"));
		
		when(bookService.getBookById(book.getId())).thenReturn(book);
		
		ResponseEntity<BookBean> res = bookRestController.getBook(book.getId());
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(1001l, res.getBody().getId());
		assertEquals("Chetan", res.getBody().getAuthor().getFirstName());
	}
	
	//exception handling without annotation
	@Test
	public void testGetBookWhenIdIsNegative() {
		try {
			bookRestController.getBook(-1);
		} catch (BookNotFoundException e) {
			assertEquals("Employee Id is invalid. It must be greater than 0.", e.getErrorMessage());
		}
	}
}
