package com.airtel.merchant.coupon.exceptions;

public class ProcessingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1844041746898204165L;

	public ProcessingException() {
	}

	public ProcessingException(String message) {
		super(message);
	}
}
