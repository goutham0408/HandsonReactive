package com.bezkoder.spring.data.cassandra.exception;

public class NoteNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoteNotFoundException(String msg) {

		super(msg);

	}

}
