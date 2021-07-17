/**
 * 
 */
package com.practice.customexception.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.practice.customexception.exception.BadRequestException;
import com.practice.customexception.exception.PracticeCustomServiceException;

@Service
public class TestServiceImpl implements TestService {

	private static final Logger logger = LogManager.getLogger(TestServiceImpl.class);

	public String getTestData(String userInput, boolean exceptionRequired, String trackingId) {
		
		if (exceptionRequired) {
			logger.error("User has requested to test custom exception for trackingId: {}", trackingId);
			throw new PracticeCustomServiceException("User has requested to test custom exception", "TEST_ERROR");
		}
		
		if (StringUtils.isEmpty(userInput)) {
			throw new BadRequestException("Test input is null or empty", "BAD_REQUEST");
		}
		
		return userInput.toUpperCase();
	}

}
