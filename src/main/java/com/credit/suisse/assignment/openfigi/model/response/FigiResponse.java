package com.credit.suisse.assignment.openfigi.model.response;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class FigiResponse implements java.io.Serializable {
   
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("figi")
	private String figi;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("ticker")
	private String ticker;
	
	@JsonProperty("exchCode")
	private String exchCode;
	
	@JsonProperty("compositeFIGI")
	private String compositeFIGI;
	
	@JsonProperty("securityType")
	private String securityType;
	
	@JsonProperty("marketSector")
	private String marketSector;
	
	@JsonProperty("shareClassFIGI")
    private String shareClassFIGI;
	
	@JsonProperty("securityType2")
	private String securityType2;
	
	@JsonProperty("securityDescription")
	private String securityDescription;

	public String getFigi() {
		return figi;
	}

	public void setFigi(String figi) {
		this.figi = figi;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getExchCode() {
		return exchCode;
	}

	public void setExchCode(String exchCode) {
		this.exchCode = exchCode;
	}

	public String getCompositeFIGI() {
		return compositeFIGI;
	}

	public void setCompositeFIGI(String compositeFIGI) {
		this.compositeFIGI = compositeFIGI;
	}

	public String getSecurityType() {
		return securityType;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	public String getMarketSector() {
		return marketSector;
	}

	public void setMarketSector(String marketSector) {
		this.marketSector = marketSector;
	}

	public String getShareClassFIGI() {
		return shareClassFIGI;
	}

	public void setShareClassFIGI(String shareClassFIGI) {
		this.shareClassFIGI = shareClassFIGI;
	}

	public String getSecurityType2() {
		return securityType2;
	}

	public void setSecurityType2(String securityType2) {
		this.securityType2 = securityType2;
	}

	public String getSecurityDescription() {
		return securityDescription;
	}

	public void setSecurityDescription(String securityDescription) {
		this.securityDescription = securityDescription;
	}

	@Override
	public String toString() {
		return "FigiResponse [figi=" + figi + ", name=" + name + ", ticker=" + ticker + ", exchCode=" + exchCode
				+ ", compositeFIGI=" + compositeFIGI + ", securityType=" + securityType + ", marketSector="
				+ marketSector + ", shareClassFIGI=" + shareClassFIGI + ", securityType2=" + securityType2
				+ ", securityDescription=" + securityDescription + "]";
	}
}
