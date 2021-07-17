/**
 * 
 */
package com.practice.customexception.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practice.customexception.object.ErrorDetails;
import com.practice.customexception.object.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final String TRACKING_ID = "trackingId";

	private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(PracticeCustomBaseException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(HttpServletRequest request,
			PracticeCustomBaseException e) {
		ErrorDetails errorDetails = new ErrorDetails(e.getStatus().value(),
				updateErrorCode(request, e.getStatus().value()), e.getCode(), e.getMessage(),
				(String) request.getAttribute(TRACKING_ID));
		ErrorResponse errorResponse = new ErrorResponse(errorDetails);
		logger.error("PracticeCustomBaseException message - {} ", e.getMessage(), e);
		return new ResponseEntity<>(errorResponse, e.getStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(HttpServletRequest request, Exception e) {
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				updateErrorCode(request, HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage(),
				(String) request.getAttribute(TRACKING_ID));
		ErrorResponse errorResponse = new ErrorResponse(errorDetails);
		logger.error("Exception message - {} ", e.getMessage(), e);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public String updateErrorCode(HttpServletRequest request, int statusCode) {
		String prefixedErrorCode = "";
		String trackingId = (String) request.getAttribute(TRACKING_ID);
		if (!StringUtils.isEmpty(trackingId)) {
			prefixedErrorCode = "ERROR-".concat(String.valueOf(statusCode)).concat("-")
					.concat(trackingId.substring(trackingId.length() - 4));
		}
		return prefixedErrorCode;
	}

}
