package com.business.clip.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.business.clip.models.error.ClipErrorMessage;
import com.business.clip.models.error.ClipServiceException;


/**
 * @author Eddy
 */
@ControllerAdvice
public class ServicesExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(ServicesExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	private ResponseEntity<ClipErrorMessage> handleException(Exception ex, WebRequest request) {
		log.error("Unhandled exception", ex);
		return new ResponseEntity<>(
				new ClipErrorMessage(String.format("Unhandled exception. Details: %s", ex.getMessage()),
						ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = ResponseStatusException.class)
	private ResponseEntity<ClipErrorMessage> handleException(ResponseStatusException ex,
			WebRequest request) {
		log.error("ResponseStatusException", ex);
		return new ResponseEntity<>(new ClipErrorMessage(ex.getReason(), ex.getMessage(), ex.getStatus().value()),
				ex.getStatus());
	}

	@ExceptionHandler(value = ClipServiceException.class)
	private ResponseEntity<ClipErrorMessage> handleException(ClipServiceException ex, WebRequest request) {
		log.error("ClipServiceException", ex);
		return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.valueOf(ex.getErrorMessage().getHttpStatus()));
	}

	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	private ResponseEntity<ClipErrorMessage> handleException(MissingServletRequestParameterException ex, WebRequest request) {
		log.error("MissingServletRequestParameterException", ex);
		return new ResponseEntity<>(new ClipErrorMessage(ex.getMessage(), ex.getMessage(),HttpStatus.CONFLICT.value()),
				HttpStatus.CONFLICT);
	}
	
}
