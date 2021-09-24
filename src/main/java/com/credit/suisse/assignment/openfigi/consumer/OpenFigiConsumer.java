package com.credit.suisse.assignment.openfigi.consumer;

import java.net.URI;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.credit.suisse.assignment.openfigi.client.OpenFigiClient;
import com.credit.suisse.assignment.openfigi.exception.ServiceException;
import com.credit.suisse.assignment.openfigi.model.request.PostFilterRequestOpenFigi;
import com.credit.suisse.assignment.openfigi.model.response.PostFilterResponseOpenFigi;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OpenFigiConsumer implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.logger(OpenFigiConsumer.class);
	@Autowired 
	private OpenFigiClient openFigiClient;

	public String[] validateExchangeCode(URI url) throws ServiceException {
		logger.info("Calling GET validatingExchange API");
		return openFigiClient.validateExchangeCode(url);
	}

	public PostFilterResponseOpenFigi retreiveMemberStockDetails(PostFilterRequestOpenFigi body, URI url) throws ServiceException {
		logger.info("Calling POST search API");
		return openFigiClient.retreiveMemberStockDetails(body, url);
	}



}
