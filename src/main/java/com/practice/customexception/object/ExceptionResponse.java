package com.practice.customexception.object;

public class ExceptionResponse {

    private String errorCode;
	
    private String errorMessage;
	
    private String errorKey;

    public ExceptionResponse() {
    }
    
    public ExceptionResponse(int errorCode, String errorMessage) {
    	this.errorCode = Integer.toString(errorCode);
    	this.errorMessage = errorMessage;
    	this.errorKey = "ERROR";
    }
    
    public ExceptionResponse(int errorCode, String errorMessage, String errorKey) {
    	this.errorCode = Integer.toString(errorCode);
    	this.errorMessage = errorMessage;
    	this.errorKey = (errorKey == null || errorKey.isEmpty()) ? "ERROR" : errorKey;
    }

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errorKey=" + errorKey
				+ "]";
	}

}