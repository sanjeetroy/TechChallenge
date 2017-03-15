package com.techchallenge.service;

import com.techchallenge.domain.AdminAccount;
import com.techchallenge.beans.Company;
import com.techchallenge.beans.Creator;
import com.techchallenge.beans.Marketplace;
import com.techchallenge.dao.DaoAdminAccountImpl;

public class ServiceAdminAccount {
	public void save(String accountIdentifier,Creator creator,Company company,Marketplace marketplace,String status){
		AdminAccount adminAccount = new AdminAccount();
		
		adminAccount.setAccountIdentifier(accountIdentifier);
		adminAccount.setAdminUserIdentifier(creator.getUuid());
		adminAccount.setCompanyUuid(company.getUuid());
		adminAccount.setPartner(marketplace.getPartner());
		adminAccount.setBaseUrl(marketplace.getBaseUrl());
		adminAccount.setStatus(status);
		
		DaoAdminAccountImpl daoAdminAccountImpl = new DaoAdminAccountImpl();
		daoAdminAccountImpl.save(adminAccount);
	}
	
	public String getAdminUuidByAccountIdentifier(String accountIdentifier){
		DaoAdminAccountImpl daoAdminAccountImpl = new DaoAdminAccountImpl();
		return daoAdminAccountImpl.getAdminByAccountIdentifier(accountIdentifier);
	}
	
	public AdminAccount getAdminAccountByAccountIdentifier(String accountIdentifier){
		DaoAdminAccountImpl daoAdminAccountImpl = new DaoAdminAccountImpl();
		return daoAdminAccountImpl.getAdminAccountByAccountIdentifier(accountIdentifier);
	}
	
	public void update(String accountIdentifier,Creator creator,Company company,Marketplace marketplace,String status){
		AdminAccount adminAccount = new AdminAccount();
		
		adminAccount.setAccountIdentifier(accountIdentifier);
		adminAccount.setAdminUserIdentifier(creator.getUuid());
		adminAccount.setCompanyUuid(company.getUuid());
		adminAccount.setPartner(marketplace.getPartner());
		adminAccount.setBaseUrl(marketplace.getBaseUrl());
		adminAccount.setStatus(status);
		
		DaoAdminAccountImpl daoAdminAccountImpl = new DaoAdminAccountImpl();
		daoAdminAccountImpl.update(adminAccount);
	}
	
	public void update(AdminAccount adminAccount){
		
		DaoAdminAccountImpl daoAdminAccountImpl = new DaoAdminAccountImpl();
		daoAdminAccountImpl.update(adminAccount);
	}
}
