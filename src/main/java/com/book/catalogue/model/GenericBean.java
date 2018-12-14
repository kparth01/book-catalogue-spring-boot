package com.book.catalogue.model;

import java.io.Serializable;

/**
 * This is the generic bean. Every model/bean must extend this bean.
 */

public class GenericBean implements Serializable {
	
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
