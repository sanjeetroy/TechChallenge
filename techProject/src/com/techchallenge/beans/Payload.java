package com.techchallenge.beans;

import java.util.List;

public class Payload {
	
	private Creator user; 
	private Company company; 
	private Account account; 
	private AddonInstance addonInstance; 
	private AddonBinding addonBinding; 
	private Order order; 
	private Notice notice; 
	private Configuration configuration;
	
	public Creator getUser() {
		return user;
	}
	public void setUser(Creator user) {
		this.user = user;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public AddonInstance getAddonInstance() {
		return addonInstance;
	}
	public void setAddonInstance(AddonInstance addonInstance) {
		this.addonInstance = addonInstance;
	}
	public AddonBinding getAddonBinding() {
		return addonBinding;
	}
	public void setAddonBinding(AddonBinding addonBinding) {
		this.addonBinding = addonBinding;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
		
	
}
