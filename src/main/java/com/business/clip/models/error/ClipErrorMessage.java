package com.business.clip.models.error;

/**
 * @author Eddy
 */
public class ClipErrorMessage {

	private String developerMessage;
	private String message;
	private int httpStatus;

	public ClipErrorMessage(String message, String developerMessage, int httpStatus) {
		this.developerMessage = developerMessage;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ClipErrorMessage [developerMessage=" + developerMessage + ", message=" + message + ", httpStatus="
				+ httpStatus + "]";
	}
}
