package com.credit.suisse.assignment.openfigi.exception;

import org.springframework.http.HttpStatus;
import com.credit.suisse.assignment.openfigi.model.response.ErrorMessage;

public class GatewayTimeOutException extends ServiceException{

	private static final long serialVersionUID = 1L;
	ErrorMessage errorMessage;

	public GatewayTimeOutException(final String msg) {
		super(String.valueOf(HttpStatus.GATEWAY_TIMEOUT), msg);
	}

	public GatewayTimeOutException(final String msg, ErrorMessage errorMessage) {
		super(String.valueOf(HttpStatus.GATEWAY_TIMEOUT), msg);
		this.errorMessage = errorMessage;
	}

	public GatewayTimeOutException(final String msg, final Throwable cause) {
		super(String.valueOf(HttpStatus.GATEWAY_TIMEOUT), msg, cause);
	}

	public GatewayTimeOutException(String reasonCode, final String msg) {
		super(reasonCode, msg);
	} 

	public GatewayTimeOutException(String reasonCode, final String msg, final Throwable cause) {
		super(reasonCode, msg, cause);
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
}
