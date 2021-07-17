/**
 * 
 */
package com.practice.customexception.exception;

import org.springframework.http.HttpStatus;

public class PracticeCustomBaseException extends RuntimeException {

	private static final long serialVersionUID = 4729283761141836479L;

	final HttpStatus status;

	final String code;

	public PracticeCustomBaseException(HttpStatus statusCode, String code, String message) {
		super(message);
		status = statusCode;
		this.code = code;
	}

	public PracticeCustomBaseException(HttpStatus statusCode, String message) {
		super(message);
		status = statusCode;
		this.code = "";
	}

	public PracticeCustomBaseException(HttpStatus statusCode, String message, Throwable cause) {
		super(message, cause);
		status = statusCode;
		this.code = "";
	}

	public PracticeCustomBaseException(HttpStatus statusCode, String message, String code, Throwable cause) {
		super(message, cause);
		status = statusCode;
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

}
