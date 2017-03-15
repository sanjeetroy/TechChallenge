package com.techchallenge.service;

import com.techchallenge.dao.DaoCompanyImpl;
import com.techchallenge.domain.Company;

public class ServiceCompany {
	public void saveCompany(com.techchallenge.beans.Company company){
		Company damainCompany = new Company();
		
		damainCompany.setUuid(company.getUuid());
		damainCompany.setExternalId(company.getExternalId());
		damainCompany.setName(company.getName());
		damainCompany.setEmail(company.getEmail());
		damainCompany.setPhoneNumber(company.getPhoneNumber());
		damainCompany.setWebsite(company.getWebsite());
		damainCompany.setCountry(company.getCountry());
		
		DaoCompanyImpl daoComapnyImpl = new DaoCompanyImpl();
		daoComapnyImpl.save(damainCompany);
	}
	
	public Company findByUuid(String uuid){
		DaoCompanyImpl daoComapnyImpl = new DaoCompanyImpl();
		return daoComapnyImpl.findByUuid(uuid);
	}
}
