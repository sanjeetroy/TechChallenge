package com.techchallenge.domain;

public class Order {
	private int orderIdentifier; //auto_increment
	private String editionCode; 
	private String addonOfferingCode; 
	private String pricingDuration;
	private String itemsUnit;
	private String itemsQuantity;
	private String creatorUuid;
	
	public int getOrderIdentifier() {
		return orderIdentifier;
	}
	public void setOrderIdentifier(int orderIdentifier) {
		this.orderIdentifier = orderIdentifier;
	}
	public String getEditionCode() {
		return editionCode;
	}
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}
	public String getAddonOfferingCode() {
		return addonOfferingCode;
	}
	public void setAddonOfferingCode(String addonOfferingCode) {
		this.addonOfferingCode = addonOfferingCode;
	}
	public String getPricingDuration() {
		return pricingDuration;
	}
	public void setPricingDuration(String pricingDuration) {
		this.pricingDuration = pricingDuration;
	}
	public String getItemsUnit() {
		return itemsUnit;
	}
	public void setItemsUnit(String itemsUnit) {
		this.itemsUnit = itemsUnit;
	}
	public String getItemsQuantity() {
		return itemsQuantity;
	}
	public void setItemsQuantity(String itemsQuantity) {
		this.itemsQuantity = itemsQuantity;
	}
	public String getCreatorUuid() {
		return creatorUuid;
	}
	public void setCreatorUuid(String creatorUuid) {
		this.creatorUuid = creatorUuid;
	}
	
	

}
