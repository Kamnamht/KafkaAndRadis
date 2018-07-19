package com.airtel.merchant.coupon.exceptions;

public class DBAccessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7370446811235545835L;

	public DBAccessException() {
	}

	public DBAccessException(String message) {
		super(message);
	}
}
