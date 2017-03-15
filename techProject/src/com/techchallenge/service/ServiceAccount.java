package com.techchallenge.service;

import com.techchallenge.domain.Account;

import java.util.ArrayList;

import com.techchallenge.beans.Creator;
import com.techchallenge.common.EventTypes;
import com.techchallenge.dao.DaoAccountImpl;

public class ServiceAccount {
	public void save(com.techchallenge.beans.Account account,Creator user){
		Account domainAccount = new Account();
		domainAccount.setAccountIdentifier(account.getAccountIdentifier());
		domainAccount.setParentAccountIdentifier(account.getParentAccountIdentifier());
		domainAccount.setUserStatus("ACTIVE");
		domainAccount.setUserUuid(user.getUuid());
		
		DaoAccountImpl daoAccountImpl = new DaoAccountImpl();
		daoAccountImpl.save(domainAccount);
	}
	
	public void save(com.techchallenge.beans.Account account,Creator user,String accountIdentifier){
		Account domainAccount = new Account();
		
		if(account !=null){
			domainAccount.setAccountIdentifier(accountIdentifier);
			domainAccount.setParentAccountIdentifier(account.getParentAccountIdentifier());
			domainAccount.setUserStatus("ACTIVE");
			if(user !=null){
				domainAccount.setUserUuid(user.getUuid());
			}else{
				domainAccount.setUserUuid(null);
			}
			
		}else{
			domainAccount.setAccountIdentifier(accountIdentifier);
			domainAccount.setParentAccountIdentifier(null);
			domainAccount.setUserStatus("ACTIVE");
			if(user !=null){
				domainAccount.setUserUuid(user.getUuid());
			}else{
				domainAccount.setUserUuid(null);
			}
			
			
		}
		
		DaoAccountImpl daoAccountImpl = new DaoAccountImpl();
		daoAccountImpl.save(domainAccount);
	}
	
	public ArrayList<Account> findByAccountIdentifier(String accountIdentifier){
		DaoAccountImpl daoAccountImpl = new DaoAccountImpl();
		return daoAccountImpl.findByAccountIdentifier(accountIdentifier);
	}
	
	public Account findAccountByUserUuid(String uuid){
		DaoAccountImpl daoAccountImpl = new DaoAccountImpl();
		return daoAccountImpl.findByUuid(uuid);
	}
	
	public void updateAccount(Account account){
		DaoAccountImpl daoAccountImpl = new DaoAccountImpl();
		daoAccountImpl.update(account);
	}
	public boolean isUserAlreadyAddedInTheAccount(String uuid){
		DaoAccountImpl daoAccountImpl = new DaoAccountImpl();
		return daoAccountImpl.isUserAlreadyAddedInTheAccount(uuid);
	}
	
	public boolean isUserAlreadyAddedInTheAccount(String uuid,String accountIdentifier){
		if(isUserAlreadyAddedInTheAccount(uuid)){
			Account account = findAccountByUserUuid(uuid);
			if(account.getAccountIdentifier().equals(accountIdentifier)){
				return true;
			}
			else{
				return false;
			}
		}
		
		return false;
	}
	
	public ArrayList<String> getAllUsersByAccountIdentifier(String accountIdentifier){
		DaoAccountImpl daoAccountImpl = new DaoAccountImpl();
		return daoAccountImpl.getAllUsersByAccountIdentifier(accountIdentifier);
	}
}
