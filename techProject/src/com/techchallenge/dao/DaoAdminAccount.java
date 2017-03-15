package com.techchallenge.dao;

import com.techchallenge.domain.AdminAccount;
import com.techchallenge.domain.User;

public interface DaoAdminAccount {
	public void save(AdminAccount adminAccount);
	public String getAdminByAccountIdentifier(String accountIdentifier);
	public AdminAccount getAdminAccountByAccountIdentifier(String accountIdentifier);
	public void update(AdminAccount adminAccount);
	
}
