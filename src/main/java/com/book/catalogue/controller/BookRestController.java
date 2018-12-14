package com.book.catalogue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.book.catalogue.exception.BookException;
import com.book.catalogue.exception.BookNotFoundException;
import com.book.catalogue.exception.ErrorResponse;
import com.book.catalogue.model.BookBean;
import com.book.catalogue.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/book")
public class BookRestController {

	private final Logger logger = LoggerFactory.getLogger(BookRestController.class);
	
	@Autowired
	private BookService bookService;
	
	@ApiOperation(value="Create and update book details")
	@RequestMapping(value="/createOrUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookBean> createOrUpdateBook(@RequestBody BookBean book) {
		logger.debug("create or update a book");
		if (book != null && StringUtils.isEmpty(book.getBookName()) ) {
			throw new BookException("Book name cannot be empty.");
		}
		book = bookService.createBook(book);
		return new ResponseEntity<BookBean>(book, HttpStatus.OK);
	}
	
	@ApiOperation(value="Fetch book details")
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookBean> getBook(@PathVariable long id) {
		logger.debug("Fetching book details for id: " + id);
		if(id <= 0) {
			throw new BookNotFoundException("Employee Id is invalid. It must be greater than 0.");
		}
		BookBean book = bookService.getBookById(id);
		return new ResponseEntity<BookBean>(book, HttpStatus.OK);
	}
	
	@ExceptionHandler({BookNotFoundException.class, BookException.class})
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
}
