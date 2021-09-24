package com.credit.suisse.assignment.openfigi.exceptionHandler;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.credit.suisse.assignment.openfigi.exception.DataNotFoundException;
import com.credit.suisse.assignment.openfigi.exception.GatewayTimeOutException;
import com.credit.suisse.assignment.openfigi.exception.ServiceException;
import com.credit.suisse.assignment.openfigi.helper.ErrorMessageValidator;
import com.credit.suisse.assignment.openfigi.model.response.ErrorResponse;


@ControllerAdvice
public class OpenFigiGlobalExceptionHandler implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired 
	ErrorMessageValidator errorValidator;

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<Object> handleExchangeCode(ServiceException ex, HttpServletResponse response){
		boolean recoverable = false;
		ErrorResponse errorResponse = null;
		String reasonCode = ex.getMessage();
		if(ex instanceof DataNotFoundException) {
			errorResponse = errorValidator.build("Resource Not found", reasonCode, recoverable, ex.getMessage());
		}
		else if(ex instanceof GatewayTimeOutException) {
			errorResponse = errorValidator.build("Gateway Timeout", reasonCode, recoverable, ex.getMessage());
		}
		return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
