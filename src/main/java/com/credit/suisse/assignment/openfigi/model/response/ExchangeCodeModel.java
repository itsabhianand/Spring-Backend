package com.credit.suisse.assignment.openfigi.model.response;

import java.util.Arrays;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class ExchangeCodeModel implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("values")
	private String[] values;

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "ExchangeCodeModel [values=" + Arrays.toString(values) + "]";
	}
}
