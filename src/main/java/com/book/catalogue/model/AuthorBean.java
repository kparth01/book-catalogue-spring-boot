package com.book.catalogue.model;

public class AuthorBean extends GenericBean {

	private String firstName;
	private String lastName;
	
	public AuthorBean() {};
	
	public AuthorBean(long id, String firstName, String lastName) {
		setId(id);
		setFirstName(firstName).setLastName(lastName);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public AuthorBean setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public AuthorBean setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
}
