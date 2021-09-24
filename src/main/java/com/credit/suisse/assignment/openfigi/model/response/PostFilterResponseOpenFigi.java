package com.credit.suisse.assignment.openfigi.model.response;

import java.util.List;
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
public class PostFilterResponseOpenFigi implements java.io.Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("data")
	private List<FigiResponse> data;

	public List<FigiResponse> getData() {
		return data;
	}
	public void setData(List<FigiResponse> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "PostFilterResponseOpenFigi [data=" + data + "]";
	}
}
