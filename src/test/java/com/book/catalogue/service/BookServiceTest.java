package com.book.catalogue.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.book.catalogue.exception.BookNotFoundException;
import com.book.catalogue.model.AuthorBean;
import com.book.catalogue.model.BookBean;

public class BookServiceTest {
	
	
	private BookService bookService;
	
	@Before
	public void before() {
		bookService = new BookService();
	}
	
	@Test
	public void testCreateBook() {
		BookBean book  = new BookBean();
		book.setId(0);
		book.setBookName("2 States")
			.setBookDesc("Love Story")
			.setAuthor(new AuthorBean(0, "Chetan", "Bhagat"));
		
		BookBean res = bookService.createBook(book);
		
		assertEquals(1, res.getId());
		assertEquals(1, res.getAuthor().getId());
		assertEquals(book.getBookName(), res.getBookName());
	}
	
	@Test
	public void testUpdateBook() {
		BookBean book  = new BookBean();
		book.setId(1001l);
		book.setBookName("2 States")
			.setBookDesc("Love Story")
			.setAuthor(new AuthorBean(1001l, "Chetan", "Bhagat"));
		
		bookService.bookTempDataMap.put(1001l, book);
		
		BookBean book2  = new BookBean();
		book2.setId(1001l);
		book2.setBookName("2 States")
			.setBookDesc("Love Story")
			.setAuthor(new AuthorBean(1001l, "Chetan", "Bhageth"));
		
		BookBean res = bookService.updateBook(book2);
		
		assertEquals(1001l, res.getId());
		assertEquals(1001l, res.getAuthor().getId());
		assertEquals("Bhageth", res.getAuthor().getLastName());
	}

	@Test
	public void testGetBookById() {
		bookService.bookTempDataMap.put(1001l, createBookInstance(1001l, "Book1", "", "", ""));
		bookService.bookTempDataMap.put(1002l, createBookInstance(1002l, "Book2", "", "", ""));
		bookService.bookTempDataMap.put(1003l, createBookInstance(1003l, "Book3", "", "", ""));
		bookService.bookTempDataMap.put(1004l, createBookInstance(1004l, "Book4", "", "", ""));
		bookService.bookTempDataMap.put(1005l, createBookInstance(1005l, "Book5", "", "", ""));
		
		BookBean book = bookService.getBookById(1004l);
		
		assertEquals("Book4", book.getBookName());
	}
	
	@Test
	public void testGetBookByIdWhenIdIsNotFound() {
		
		long bookId = 5001l;
		
		bookService.bookTempDataMap.put(1001l, createBookInstance(1001l, "Book1", "", "", ""));
		bookService.bookTempDataMap.put(1002l, createBookInstance(1002l, "Book2", "", "", ""));
		bookService.bookTempDataMap.put(1003l, createBookInstance(1003l, "Book3", "", "", ""));
		bookService.bookTempDataMap.put(1004l, createBookInstance(1004l, "Book4", "", "", ""));
		bookService.bookTempDataMap.put(1005l, createBookInstance(1005l, "Book5", "", "", ""));
		
		try {
			BookBean book = bookService.getBookById(bookId);
		} catch (BookNotFoundException e) {
			assertEquals("Book not found with Id: " + bookId, e.getErrorMessage());
		}

	}
	
	private BookBean createBookInstance(long bookId, String bookName, String bookDesc, String authorFName, String authorLName) {
		
		BookBean book  = new BookBean();
		book.setId(bookId);
		book.setBookName(bookName)
			.setBookDesc(bookDesc)
			.setAuthor(new AuthorBean(1001l, authorFName, authorLName));
		
		return book;
	}
	
}
