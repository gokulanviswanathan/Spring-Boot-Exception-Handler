package com.practice.customexception.exception;

import org.springframework.http.HttpStatus;

public class PracticeCustomServiceException extends PracticeCustomBaseException {

	private static final long serialVersionUID = 7332109793266445444L;

	public PracticeCustomServiceException(String message) {
		super(HttpStatus.NOT_ACCEPTABLE, "CUSTOM_ERROR", message);
	}

	public PracticeCustomServiceException(String message, String messageCode) {
		super(HttpStatus.NOT_ACCEPTABLE, messageCode, message);
	}

	public PracticeCustomServiceException(String message, String messageCode, Throwable cause) {
		super(HttpStatus.NOT_ACCEPTABLE, message, messageCode, cause);
	}

}
