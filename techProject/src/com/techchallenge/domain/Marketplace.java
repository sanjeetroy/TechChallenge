package com.techchallenge.domain;

public class Marketplace {
	private int marketplaceIdentifier;  //auto_increment
	private String partner;
	private String baseUrl;
	
	public int getMarketplaceIdentifier() {
		return marketplaceIdentifier;
	}
	public void setMarketplaceIdentifier(int marketplaceIdentifier) {
		this.marketplaceIdentifier = marketplaceIdentifier;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	
}
