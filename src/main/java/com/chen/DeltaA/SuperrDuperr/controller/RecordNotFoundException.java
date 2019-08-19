package com.chen.DeltaA.SuperrDuperr.controller;

public class RecordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message, Throwable casue) {
		super(message, casue);
	}

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(Throwable casue) {
		super(casue);
	}
	

}
