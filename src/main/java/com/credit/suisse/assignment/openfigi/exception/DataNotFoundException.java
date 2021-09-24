package com.credit.suisse.assignment.openfigi.exception;

import org.springframework.http.HttpStatus;
import com.credit.suisse.assignment.openfigi.model.response.ErrorMessage;

public class DataNotFoundException extends ServiceException {

	private static final long serialVersionUID = 1L;
	ErrorMessage errorMessage;

	public DataNotFoundException(final String msg) {
		super(String.valueOf(HttpStatus.NOT_FOUND), msg);
	}

	public DataNotFoundException(final String msg, ErrorMessage errorMessage) {
		super(String.valueOf(HttpStatus.NOT_FOUND), msg);
		this.errorMessage = errorMessage;
	}

	public DataNotFoundException(final String msg, final Throwable cause) {
		super(String.valueOf(HttpStatus.NOT_FOUND), msg, cause);
	}

	public DataNotFoundException(String reasonCode, final String msg) {
		super(reasonCode, msg);
	} 

	public DataNotFoundException(String reasonCode, final String msg, final Throwable cause) {
		super(reasonCode, msg, cause);
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
}
