package com.techchallenge.controller;

import java.util.ArrayList;


import com.techchallenge.beans.*;
import com.techchallenge.domain.Account;
import com.techchallenge.domain.AdminAccount;
import com.techchallenge.domain.Company;
import com.techchallenge.domain.Order;
import com.techchallenge.domain.User;
import com.techchallenge.exceptions.CustomParentException;
import com.techchallenge.exceptions.UserAlreadyExistsException;
import com.techchallenge.service.ServiceAccount;
import com.techchallenge.service.ServiceAdminAccount;
import com.techchallenge.service.ServiceCompany;
import com.techchallenge.service.ServiceMarketplace;
import com.techchallenge.service.ServiceOrder;
import com.techchallenge.service.ServiceUser;

public class DbController {
	
	
	public static void  pushInCreator(Creator creator,String accIdentifier) {
			ServiceUser serviceUser = new ServiceUser();
			serviceUser.saveCreator(creator, accIdentifier);
		
	}
	
	public static void  pushInUser(Creator user,String accIdentifier){
		ServiceUser serviceUser = new ServiceUser();
		serviceUser.saveUser(user, accIdentifier);
		
	}

	public static User findByUuidInUser(String uuid){
		ServiceUser serviceUser = new ServiceUser();
		return serviceUser.findByUuid(uuid);
	}
	
	public static User findByUuidInCreator(String uuid){
		return findByUuidInUser(uuid);
	}
	
	public static void  pushInAccount(com.techchallenge.beans.Account account,Creator user){
		ServiceAccount serviceAccount = new ServiceAccount();
		serviceAccount.save(account, user);
	}

	public static void  pushInAccount(com.techchallenge.beans.Account account,Creator user,String accountIdentifier){
		ServiceAccount serviceAccount = new ServiceAccount();
		serviceAccount.save(account, user,accountIdentifier);
	}
	
	public static ArrayList<Account> findByAccountIdentifierInAccount(String accountIdentifier){
		ServiceAccount serviceAccount = new ServiceAccount();
		return serviceAccount.findByAccountIdentifier(accountIdentifier);
	}
	
	public static Account findAccountByUserUuid(String uuid){
		ServiceAccount serviceAccount = new ServiceAccount();
		return serviceAccount.findAccountByUserUuid(uuid);
	}
	
	public static void updateAccountInAccount(Account account){
		ServiceAccount serviceAccount = new ServiceAccount();
		serviceAccount.updateAccount(account);
	}
	public static boolean isUserAlreadyAddedInTheAccount(String uuid){
		ServiceAccount serviceAccount = new ServiceAccount();
		return serviceAccount.isUserAlreadyAddedInTheAccount(uuid);
	}
	
	public static boolean isUserAlreadyAddedInTheAccount(String uuid,String accountIdentifier){
		ServiceAccount serviceAccount = new ServiceAccount();
		return serviceAccount.isUserAlreadyAddedInTheAccount(uuid,accountIdentifier);
	}
	
	public static ArrayList<String> getAllUsersByAccountIdentifier(String accountIdentifier){
		ServiceAccount serviceAccount = new ServiceAccount();
		return serviceAccount.getAllUsersByAccountIdentifier(accountIdentifier);
	}
	
	public static void pushInAdminAccount(String accountIdentifier,Creator creator,com.techchallenge.beans.Company company,Marketplace marketplace,String status){
		ServiceAdminAccount serviceAdminAccount = new ServiceAdminAccount();
		serviceAdminAccount.save(accountIdentifier, creator, company, marketplace, status);
	}
	
	public static String getAdminUuidByAccountIdentifier(String accountIdentifier){
		ServiceAdminAccount serviceAdminAccount = new ServiceAdminAccount();
		return serviceAdminAccount.getAdminUuidByAccountIdentifier(accountIdentifier);
	}
	
	public static AdminAccount getAdminAccountByAccountIdentifier(String accountIdentifier){
		ServiceAdminAccount serviceAdminAccount = new ServiceAdminAccount();
		return serviceAdminAccount.getAdminAccountByAccountIdentifier(accountIdentifier);
	}
	
	public static void updateInAdminAccount(String accountIdentifier,Creator creator,com.techchallenge.beans.Company company,Marketplace marketplace,String status){
		ServiceAdminAccount serviceAdminAccount = new ServiceAdminAccount();
		serviceAdminAccount.update(accountIdentifier, creator, company, marketplace, status);
	}
	
	public static void updateInAdminAccount(AdminAccount adminAccount){
		ServiceAdminAccount serviceAdminAccount = new ServiceAdminAccount();
		serviceAdminAccount.update(adminAccount);
	}
	
	public static void  pushInCompany(com.techchallenge.beans.Company company){
		ServiceCompany serviceCompany = new ServiceCompany();
		serviceCompany.saveCompany(company);
	}
	
	public static Company findByUuidInCompany(String uuid){
		ServiceCompany serviceCompany = new ServiceCompany();
		return serviceCompany.findByUuid(uuid);
	}
	
	public static void  pushInOrder(com.techchallenge.beans.Order order,Creator creator){
		ServiceOrder serviceOrder = new ServiceOrder();
		serviceOrder.saveOrder(order, creator);
	}

	public static void updateOrder(com.techchallenge.domain.Order order){
		ServiceOrder serviceOrder = new ServiceOrder();
		serviceOrder.updateOrder(order);
	}
	
	public static Order findByCreatorUuidInOrder(String uuid){
		ServiceOrder serviceOrder = new ServiceOrder();
		return serviceOrder.findByUuid(uuid);
	}
	public static void pushInMarketPlace(Marketplace marketplace){
		ServiceMarketplace serviceMarketplace = new ServiceMarketplace();
		serviceMarketplace.save(marketplace);
	}
	
}
