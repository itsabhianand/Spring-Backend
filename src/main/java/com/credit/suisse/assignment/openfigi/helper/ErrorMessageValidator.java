package com.credit.suisse.assignment.openfigi.helper;

import org.springframework.stereotype.Component;
import com.credit.suisse.assignment.openfigi.model.response.ErrorMessage;
import com.credit.suisse.assignment.openfigi.model.response.ErrorResponse;

@Component
public class ErrorMessageValidator  implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	public static  ErrorMessage buildErrorMessage(String errorDescription, String responseCode, boolean recoverable, String detail) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setDescription(errorDescription);
		errorMessage.setReasonCode(responseCode);
		errorMessage.setRecoverable(recoverable);
		errorMessage.setDetails(detail);

		return errorMessage;
	}

	public ErrorResponse build(String errorDescription, String responseCode, boolean recoverable, String details) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setSource(OpenFigiConstants.APP);
		errorMessage.setDescription(errorDescription);
		errorMessage.setReasonCode(responseCode);
		errorMessage.setRecoverable(recoverable);
		errorMessage.setDetails(details);

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.addErrorMessage(errorMessage);

		return errorResponse;

	}
}
