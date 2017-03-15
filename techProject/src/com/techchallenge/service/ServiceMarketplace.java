package com.techchallenge.service;

import com.techchallenge.dao.DaoMarketplaceImpl;
import com.techchallenge.domain.Marketplace;

public class ServiceMarketplace {
	public void save(com.techchallenge.beans.Marketplace marketplace){
		Marketplace domainMarketplace = new Marketplace();
		
		domainMarketplace.setPartner(marketplace.getPartner());
		domainMarketplace.setBaseUrl(marketplace.getBaseUrl());
		
		DaoMarketplaceImpl daomarketplaceImpl = new DaoMarketplaceImpl();
		
		daomarketplaceImpl.save(domainMarketplace);
	}

}
