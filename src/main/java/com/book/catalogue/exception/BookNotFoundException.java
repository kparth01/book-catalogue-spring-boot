package com.book.catalogue.exception;

public class BookNotFoundException extends RuntimeException {

	static final long serialVersionUID = -7034897190745766878L;
	
	private String errorMessage;
	 
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public BookNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public BookNotFoundException() {
		super();
	}
	
	public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
