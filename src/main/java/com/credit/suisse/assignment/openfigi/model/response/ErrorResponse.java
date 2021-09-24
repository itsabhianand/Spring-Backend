package com.credit.suisse.assignment.openfigi.model.response;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@JsonInclude(Include.NON_EMPTY)
public class ErrorResponse {

	@JsonProperty("Errors")
	private Errors errors;

	public boolean addErrorMessage(ErrorMessage errorMessage) {
		boolean success = false;
		if(errors == null) {
			errors = new Errors(errorMessage);
		}
		return success;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

}
