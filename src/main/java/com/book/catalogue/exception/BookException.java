package com.book.catalogue.exception;

public class BookException extends RuntimeException {

static final long serialVersionUID = -7034897190745766878L;
	
	private String errorMessage;
	 
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public BookException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public BookException() {
		super();
	}
	
	public BookException(String message, Throwable cause) {
        super(message, cause);
    }

}
