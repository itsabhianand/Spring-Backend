package com.credit.suisse.assignment.openfigi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.credit.suisse.assignment.openfigi.exception.ServiceException;
import com.credit.suisse.assignment.openfigi.helper.ErrorMessageValidator;
import com.credit.suisse.assignment.openfigi.helper.OpenFigiConstants;
import com.credit.suisse.assignment.openfigi.model.request.PostFilterRequestOpenFigi;
import com.credit.suisse.assignment.openfigi.model.response.ErrorMessage;
import com.credit.suisse.assignment.openfigi.model.response.PostFilterResponseOpenFigi;
import com.credit.suisse.assignment.openfigi.service.OpenFigiService;
import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@Validated
@RequestMapping("/openfigi")
public class OpenFigiController implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	OpenFigiService openFigiService;

	@PostMapping(path = "/stocks", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostFilterResponseOpenFigi> getNifty50MemberStocks(@Valid @RequestBody PostFilterRequestOpenFigi body) {
		PostFilterResponseOpenFigi response = null;
		response = openFigiService.getNifty50MemberStocks(body); 
		return new ResponseEntity<PostFilterResponseOpenFigi>(response, HttpStatus.OK);	
	}

}
