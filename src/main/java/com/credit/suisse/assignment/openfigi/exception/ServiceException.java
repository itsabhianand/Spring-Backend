package com.credit.suisse.assignment.openfigi.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import com.credit.suisse.assignment.openfigi.helper.OpenFigiConstants;
import com.credit.suisse.assignment.openfigi.model.response.ErrorMessage;

public class ServiceException extends NestedRuntimeException{

	private static final long serialVersionUID = 1L;
	protected String reasonCode;
	ErrorMessage errorMessage;

	public ServiceException(final String msg) {
		super(msg);
		reasonCode = String.valueOf(HttpStatus.BAD_REQUEST);
	}

	public ServiceException(final String msg, final Throwable cause) {
		super(msg, cause);
		reasonCode = String.valueOf(HttpStatus.BAD_REQUEST);
	}

	public ServiceException(String reasonCode, final String msg) {
		super(msg);
		this.reasonCode = reasonCode;
	} 

	public ServiceException(String reasonCode, final String msg, final Throwable cause) {
		super(msg, cause);
		this.reasonCode = reasonCode;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

}
