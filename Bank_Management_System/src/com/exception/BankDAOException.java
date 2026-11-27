package com.exception;

public class BankDAOException extends RuntimeException {

	public BankDAOException() {

	}

	public BankDAOException(String msg) {
		super(msg);
	}

}
