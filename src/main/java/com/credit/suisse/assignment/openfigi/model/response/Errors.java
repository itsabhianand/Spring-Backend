package com.credit.suisse.assignment.openfigi.model.response;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@JsonInclude(Include.NON_EMPTY)
public class Errors {
	
	@JsonProperty("Error")
	private ErrorMessage erroMessage;

	public Errors(ErrorMessage errorMessage) {
		this.erroMessage = errorMessage;
	}

	public ErrorMessage getErroMessage() {
		return erroMessage;
	}

	public void setErroMessage(ErrorMessage erroMessage) {
		this.erroMessage = erroMessage;
	}
}
