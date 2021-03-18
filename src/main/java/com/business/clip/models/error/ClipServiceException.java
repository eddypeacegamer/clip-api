package com.business.clip.models.error;

/**
 * @author Eddy
 */
public class ClipServiceException extends Exception {

	private static final long serialVersionUID = 8935637626264304418L;

	private ClipErrorMessage errorMessage;

	public ClipServiceException(String message, String developerMessage, int httpStatus) {
		super(message);
		this.errorMessage = new ClipErrorMessage(message,developerMessage,httpStatus);
	}

	public ClipErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ClipErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}


}
