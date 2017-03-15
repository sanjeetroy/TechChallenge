package com.techchallenge.domain;

public class AdminAccount {
	private String accountIdentifier;
	private String adminUserIdentifier;
	private String CompanyUuid;
	private String partner;
	private String baseUrl;
	private String status;
	
	public String getAccountIdentifier() {
		return accountIdentifier;
	}
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	public String getAdminUserIdentifier() {
		return adminUserIdentifier;
	}
	public void setAdminUserIdentifier(String adminUserIdentifier) {
		this.adminUserIdentifier = adminUserIdentifier;
	}
	public String getCompanyUuid() {
		return CompanyUuid;
	}
	public void setCompanyUuid(String companyUuid) {
		CompanyUuid = companyUuid;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
