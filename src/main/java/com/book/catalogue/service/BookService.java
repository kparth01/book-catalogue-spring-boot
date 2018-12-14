package com.book.catalogue.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.book.catalogue.exception.BookNotFoundException;
import com.book.catalogue.model.AuthorBean;
import com.book.catalogue.model.BookBean;

@Service("bookService")
public class BookService {
	
	/** Temp variable for holding the book list for operations 
	 * since there is no database required for this sample.
	 * Kindly note that, when database is available <code>bookTempDataMap.put(key, value)</code>
	 * and <code>bookTempDataMap.get(key)</code> will be replaced with actual database calls.
	 */
	static Map<Long, BookBean> bookTempDataMap = new HashMap<Long, BookBean>();
	static long bookIdCnt = 0;
	
	
	public BookBean createBook(BookBean book) {
		
		if(book != null) {
			if (book.getId() == 0) {
				//create new book
				bookIdCnt = bookIdCnt + 1;
				book.setId(bookIdCnt);
				book.getAuthor().setId(bookIdCnt);
				bookTempDataMap.put(bookIdCnt, book);
			} else {
				//update book info
				return updateBook(book);
			}
		}
		return getBookById(book.getId());
	}
	
	public BookBean updateBook(BookBean book) {
		
		BookBean bookDB = null;
		
		if(book != null && book.getId() > 0) {
			//update book
			bookDB = getBookById(book.getId());
			
			bookDB.setBookName(StringUtils.isEmpty(book.getBookName()) ? "" : book.getBookName())
				.setBookDesc(StringUtils.isEmpty(book.getBookDesc()) ? "" : book.getBookDesc())
				.setAuthor(new AuthorBean(book.getId(), 
						StringUtils.isEmpty(book.getAuthor().getFirstName()) ? "" : book.getAuthor().getFirstName(),
						StringUtils.isEmpty(book.getAuthor().getLastName()) ? "" : book.getAuthor().getLastName()
						));
			
			bookTempDataMap.put(bookDB.getId(), bookDB);
		}
		return getBookById(book.getId());
	}
	
	public BookBean getBookById(long id) {		
		Optional<BookBean> book = Optional.ofNullable(bookTempDataMap.get(id));
		return book.orElseThrow(() -> new BookNotFoundException("Book not found with Id: " + id));
	}

}
