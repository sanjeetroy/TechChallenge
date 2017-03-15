package com.techchallenge.dao;

import java.util.ArrayList;

import com.techchallenge.domain.Account;
import com.techchallenge.domain.User;

public interface DaoAccount {
	public Account findByUuid(String uuid);
	public ArrayList<Account> findByAccountIdentifier(String accountIdentifier);
	public void save(Account account);
	public boolean isUserAlreadyAddedInTheAccount(String uuid);
	public ArrayList<String> getAllUsersByAccountIdentifier(String accountIdentifier);
}
