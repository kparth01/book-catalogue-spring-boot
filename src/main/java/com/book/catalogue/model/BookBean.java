package com.book.catalogue.model;

public class BookBean extends GenericBean {
	
	private String bookName;
	private String bookDesc;
	private AuthorBean author;
	
	public String getBookName() {
		return bookName;
	}
	public BookBean setBookName(String bookName) {
		this.bookName = bookName;
		return this;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public BookBean setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
		return this;
	}
	public AuthorBean getAuthor() {
		return author;
	}
	public BookBean setAuthor(AuthorBean author) {
		this.author = author;
		return this;
	}
	
}
