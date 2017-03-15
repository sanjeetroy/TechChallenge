package com.techchallenge.service;

import com.techchallenge.beans.Address;
import com.techchallenge.beans.Creator;
import com.techchallenge.dao.DaoUserImpl;
import com.techchallenge.domain.User;

public class ServiceUser {
	public void saveCreator(Creator creator,String accountIdentifier){
		User user = new User();
		user.setUuid(creator.getUuid());
		user.setEmail(creator.getEmail());
		user.setFirstName(creator.getFirstName());
		user.setLastName(creator.getLastName());
		user.setLanguage(creator.getLanguage());
		user.setLocale(creator.getLocale());
		user.setOpenId(creator.getOpenId());
		
		Address address = creator.getAddress();
		
		if(address!=null){
			user.setCity(address.getCity());
			user.setCountry(address.getCountry());
			user.setState(address.getState());
			user.setStreet1(address.getStreet1());
			user.setStree2(address.getStree2());
			user.setZip(address.getZip());
			
		}else{
			user.setCity(null);
			user.setCountry(null);
			user.setState(null);
			user.setStreet1(null);
			user.setStree2(null);
			user.setZip(null);
		}
		user.setAccountIdentifier(accountIdentifier);
		DaoUserImpl daoUserImpl = new DaoUserImpl();
		daoUserImpl.save(user);
	}
	
	public void saveUser(Creator user,String accountIdentifier){
		if(user!=null){
			saveCreator(user,accountIdentifier);
		}else{
			
		}
		
	}
	
	public User findByUuid(String uuid){
		DaoUserImpl daoUserImpl = new DaoUserImpl();
		return daoUserImpl.findByUuid(uuid);
	}
}
