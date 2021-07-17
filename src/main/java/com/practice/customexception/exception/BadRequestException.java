package com.practice.customexception.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends PracticeCustomBaseException {

	private static final long serialVersionUID = -127295839659597173L;

	public BadRequestException() {
		super(HttpStatus.BAD_REQUEST, "", "");
	}

	public BadRequestException(String message) {
		super(HttpStatus.BAD_REQUEST, "", message);
	}

	public BadRequestException(String message, String messageCode) {
		super(HttpStatus.BAD_REQUEST, messageCode, message);
	}

	public BadRequestException(String message, Throwable cause) {
		super(HttpStatus.BAD_REQUEST, message, cause);
	}
}
