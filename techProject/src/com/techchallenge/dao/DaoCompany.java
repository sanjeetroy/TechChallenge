package com.techchallenge.dao;

import com.techchallenge.domain.Company;

public interface DaoCompany {
	public void save(Company company);
	public Company findByUuid(String uuid);
	
}
