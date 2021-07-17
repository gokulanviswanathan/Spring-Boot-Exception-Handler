package com.practice.customexception.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.customexception.service.TestService;

@RestController
public class CustomExceptionController {

	@Autowired
	private TestService testService;

	@GetMapping(value = "/exceptions/v1/test", produces = "application/json")
	public ResponseEntity<String> testExceptionWithCustomData(
			@RequestParam(value = "testInput", required = false) String userInput,
			@RequestParam(value = "exceptionRequired", required = false) boolean exceptionRequired,
			@RequestParam(value = "trackingId", required = false) String trackingId) {

		if (StringUtils.isEmpty(trackingId)) {
			trackingId = "TEST-".concat(UUID.randomUUID().toString());
		}

		return new ResponseEntity<>(testService.getTestData(userInput, exceptionRequired, trackingId), HttpStatus.OK);
	}
}
