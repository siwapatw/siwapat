package com.simplejavaee.service;

import java.io.Serializable;

public class DBServiceLocatorException extends Exception implements Serializable {
	public DBServiceLocatorException() {
		super();
	}

	public DBServiceLocatorException(String arg0) {
		super(arg0);
	}
}