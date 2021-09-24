package com.credit.suisse.assignment.openfigi.model.response;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Builder
public class ErrorMessage {

	@JsonProperty("Source")
	private String source;

	@JsonProperty("ReasonCode")
	private String reasonCode;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Recoverable")
	private Boolean recoverable;

	@JsonProperty("Details")
	private String details;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getRecoverable() {
		return recoverable;
	}

	public void setRecoverable(Boolean recoverable) {
		this.recoverable = recoverable;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ErrorMessage [source=" + source + ", reasonCode=" + reasonCode + ", description=" + description
				+ ", recoverable=" + recoverable + ", details=" + details + "]";
	}
}
