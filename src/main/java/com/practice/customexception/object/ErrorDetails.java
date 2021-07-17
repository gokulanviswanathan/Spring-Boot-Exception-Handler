package com.practice.customexception.object;

public class ErrorDetails {

	private String status;
	private String code;
	private String name;
	private String message;
	private String trackingId;
	
	public ErrorDetails() {
		
	}
	
	public ErrorDetails(int status, String code, String message, String trackingId) {
		this.status = Integer.toString(status);
		this.code = code;
		this.name = "ERROR";
		this.message = message;
		this.trackingId = trackingId;
	}

	public ErrorDetails(int status, String code, String name, String message, String trackingId) {
		this.status = Integer.toString(status);
		this.code = code;
		this.name = (name == null || name.isEmpty()) ? "ERROR" : name;
		this.message = message;
		this.trackingId = trackingId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}
	
	
	
	
}
