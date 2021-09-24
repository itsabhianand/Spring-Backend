package com.credit.suisse.assignment.openfigi.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import com.credit.suisse.assignment.openfigi.consumer.OpenFigiConsumer;
import com.credit.suisse.assignment.openfigi.exception.DataNotFoundException;
import com.credit.suisse.assignment.openfigi.exception.ServiceException;
import com.credit.suisse.assignment.openfigi.helper.ErrorMessageValidator;
import com.credit.suisse.assignment.openfigi.helper.OpenFigiConstants;
import com.credit.suisse.assignment.openfigi.model.request.PostFilterRequestOpenFigi;
import com.credit.suisse.assignment.openfigi.model.response.ErrorMessage;
import com.credit.suisse.assignment.openfigi.model.response.FigiResponse;
import com.credit.suisse.assignment.openfigi.model.response.PostFilterResponseOpenFigi;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpenFigiService implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.logger(OpenFigiService.class);

	@Autowired
	private OpenFigiConsumer openFigiConsumer;

	@Value("${get.uriExchange}")
	String GET_URI_EXCH_CODE;

	@Value("${post.filter}")
	String POST_SEARCH_URI;

	URI uri;

	@Retryable(value = { Exception.class }, maxAttemptsExpression = "${retry.maxAttempts}", backoff = @Backoff(delayExpression = "${retry.delay}"))
	public PostFilterResponseOpenFigi getNifty50MemberStocks(PostFilterRequestOpenFigi body) throws ServiceException {
		logger.info("Calling getNiftyMemberStocks");
		boolean validationResult = false;
		PostFilterResponseOpenFigi response = null;
		PostFilterResponseOpenFigi finalResponse = new PostFilterResponseOpenFigi();
		uri = formEndPointURI(GET_URI_EXCH_CODE);
		String[] responseValues = openFigiConsumer.validateExchangeCode(uri);

		if(null != responseValues && responseValues.length > 0) {
			for(String s : responseValues) {
				if(s.equals(body.getExchCode())) {
					validationResult = true;
					break;
				}
			}
		}

		if(validationResult) {
			uri = formEndPointURI(POST_SEARCH_URI);
			response = openFigiConsumer.retreiveMemberStockDetails(body, uri);
			List<FigiResponse> finalResponseList = new ArrayList<FigiResponse>();
			for(FigiResponse figiResponse : response.getData()) {
				if(null != figiResponse && !(figiResponse.getName().contains(OpenFigiConstants.NEXT) || figiResponse.getName().contains(OpenFigiConstants.NXT))) {
					finalResponseList.add(figiResponse);
				}

			}
			finalResponse.setData(finalResponseList);
		}
		else {
			ErrorMessage errorMessage = ErrorMessageValidator.buildErrorMessage(OpenFigiConstants.NO_EXCHANGE_CODE_DESC, String.valueOf(HttpStatus.NOT_FOUND), false, OpenFigiConstants.NO_EXCHANGE_CODE_DETAIL);
			throw new DataNotFoundException(OpenFigiConstants.NO_EXCHANGE_CODE_DETAIL, errorMessage);
		}

		return finalResponse;
	}

	public URI formEndPointURI(String url) {
		logger.info("Calling uriFormation method");
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uri;
	}

}
