package com.credit.suisse.assignment.openfigi.model.request;

import javax.validation.constraints.NotNull;
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
public class PostFilterRequestOpenFigi implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	@JsonProperty("query")
	private String query;

	@NotNull
	@JsonProperty("exchCode")
	private String exchCode;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getExchCode() {
		return exchCode;
	}

	public void setExchCode(String exchCode) {
		this.exchCode = exchCode;
	}

	@Override
	public String toString() {
		return "PostFilterRequestOpenFigi [query=" + query + ", exchCode=" + exchCode + "]";
	}
}
