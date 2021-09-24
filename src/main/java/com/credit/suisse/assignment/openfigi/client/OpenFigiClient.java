package com.credit.suisse.assignment.openfigi.client;

import java.net.URI;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.credit.suisse.assignment.openfigi.exception.GatewayTimeOutException;
import com.credit.suisse.assignment.openfigi.exception.ServiceException;
import com.credit.suisse.assignment.openfigi.helper.ErrorMessageValidator;
import com.credit.suisse.assignment.openfigi.helper.OpenFigiConstants;
import com.credit.suisse.assignment.openfigi.model.request.PostFilterRequestOpenFigi;
import com.credit.suisse.assignment.openfigi.model.response.ErrorMessage;
import com.credit.suisse.assignment.openfigi.model.response.ExchangeCodeModel;
import com.credit.suisse.assignment.openfigi.model.response.PostFilterResponseOpenFigi;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.Logger;

@Component
@Slf4j
public class OpenFigiClient implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Value("${retry.maxAttempts}")
	private int maxAttempt;

	Logger logger = LoggerFactory.logger(OpenFigiClient.class); 

	@Autowired 
	private RestTemplate restTemplate;

	static int getCounter = 0;
	static int postCounter = 0;

	public String[] validateExchangeCode(URI url) {
		logger.info("Calling validating Exchange API using Client");
		String[] responseValues = null;
		try {
			ExchangeCodeModel response =  restTemplate.getForObject(url, ExchangeCodeModel.class);
			if(null != response)
			responseValues = response.getValues();
		}
		catch(ServiceException ex) {
			ex.printStackTrace();
			logger.info("Service Exception is thrown" + ex.getMessage());
			getCounter++;
			// Retry logic test starts
			if(getCounter > maxAttempt) {
				ErrorMessage errorMessage = ErrorMessageValidator.buildErrorMessage(OpenFigiConstants.GATEWAY_TIMEOUT, String.valueOf(HttpStatus.GATEWAY_TIMEOUT), false, OpenFigiConstants.GATEWAY_TIMEOUT);
				throw new GatewayTimeOutException(OpenFigiConstants.GATEWAY_TIMEOUT, errorMessage);
			}
			// Retry logic test ends
		}
		return responseValues;
	}


	public PostFilterResponseOpenFigi retreiveMemberStockDetails(PostFilterRequestOpenFigi body, URI url) {
		logger.info("Calling search Market API using Client");
		PostFilterResponseOpenFigi response = null;
		try {
			response = restTemplate.postForObject(url, body, PostFilterResponseOpenFigi.class);
		}
		catch(ServiceException ex) {
			logger.info("Service Exception is thrown" + ex.getMessage());
			postCounter++;
			// Retry logic test starts
			if(postCounter > maxAttempt) {
				ErrorMessage errorMessage = ErrorMessageValidator.buildErrorMessage(OpenFigiConstants.GATEWAY_TIMEOUT, String.valueOf(HttpStatus.GATEWAY_TIMEOUT), false, OpenFigiConstants.GATEWAY_TIMEOUT);
				throw new GatewayTimeOutException(OpenFigiConstants.GATEWAY_TIMEOUT, errorMessage);
			}
			// Retry logic test ends
		}
		return response;

	}

}
