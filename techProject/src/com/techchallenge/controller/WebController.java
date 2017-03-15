package com.techchallenge.controller;

import java.net.HttpURLConnection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

import com.techchallenge.beans.Payload;
import com.techchallenge.beans.SubscriptionOrderBean;
import com.techchallenge.common.AccountStatus;
import com.techchallenge.common.ErrorCodes;
import com.techchallenge.common.ResponseConstants;
import com.techchallenge.domain.Account;
import com.techchallenge.domain.AdminAccount;
import com.techchallenge.domain.Company;
import com.techchallenge.domain.Order;
import com.techchallenge.domain.User;
import com.techchallenge.exceptions.AccountNotFoundException;
import com.techchallenge.exceptions.CustomParentException;
import com.techchallenge.exceptions.ForbiddenException;
import com.techchallenge.exceptions.UserAlreadyExistsException;
import com.techchallenge.exceptions.UserNotFoundException;
import com.techchallenge.util.RandomNumber;
import com.techchallenge.util.ReadUrl;
import com.techchallenge.util.SignEventUrl;

public class WebController {

	public static String getJsonFromUrl(HttpURLConnection url){
		SignEventUrl signEventUrl = new SignEventUrl();
        HttpURLConnection signedUrl = signEventUrl.signUrl(url);
        
        try{
        	signedUrl.connect();
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        ReadUrl readUrl = new ReadUrl();
        String json = readUrl.getJson(signedUrl);
		System.out.println(json);
		return json;
	}
	
	public static SubscriptionOrderBean jsonToSubscriptionOrderBean(String json){
		
		ObjectMapper mapper = new ObjectMapper();
		SubscriptionOrderBean bean = null;
		
		try{
			bean = mapper.readValue(json, SubscriptionOrderBean.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return bean;
	}
	
	public static String pushBeanToDb(SubscriptionOrderBean bean){
		String creatorEmail = bean.getCreator().getEmail();
		String[] emailParts = creatorEmail.split("@");
		String accIdentifierFirstPart = emailParts[0];
		int accIdentifierSecondPart = RandomNumber.getRandNum();
		
		String accIdentifier = accIdentifierFirstPart + accIdentifierSecondPart;
		
		Payload payload = bean.getPayload();
		
		DbController.pushInCreator(bean.getCreator(),accIdentifier);
		
		if(payload.getAccount()==null){
			DbController.pushInAccount(payload.getAccount(),bean.getCreator(),accIdentifier);
		}else{
			DbController.pushInAccount(payload.getAccount(),bean.getCreator());
		}
		DbController.pushInCompany(payload.getCompany());
		DbController.pushInOrder(payload.getOrder(),bean.getCreator());
		DbController.pushInUser(payload.getUser(),accIdentifier);
		DbController.pushInMarketPlace(bean.getMarketplace());
		DbController.pushInAdminAccount(accIdentifier, bean.getCreator(), payload.getCompany(), bean.getMarketplace(), AccountStatus.ACTIVE);
		return accIdentifier;
	}
	
	public static void addNewUserToTheAccount(SubscriptionOrderBean bean){

		Payload payload = bean.getPayload();
		
		User user = DbController.findByUuidInUser(payload.getUser().getUuid());
		if(user==null){
			DbController.pushInUser(payload.getUser(),payload.getAccount().getAccountIdentifier());
		}
		DbController.pushInAccount(payload.getAccount(),payload.getUser());
		
	}
	public static Map<String, Object> createSubscription(String json) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		SubscriptionOrderBean bean = jsonToSubscriptionOrderBean(json);
		
		try{
			String accIdentifier = createAccount(bean);
			result.put(ResponseConstants.SUCCESS, ResponseConstants.TRUE);
			result.put(ResponseConstants.ACCOUNT_IDENTIFIER, accIdentifier);
		}catch (CustomParentException e){
			System.out.println(e.getErrorCode());
			result.put(ResponseConstants.SUCCESS, ResponseConstants.FALSE);
			result.put(ResponseConstants.ERROR_CODE, e.getErrorCode());
			result.put(ResponseConstants.MESSAGE, e.getMessage());
		}catch (Exception e) {
			System.out.println(ErrorCodes.UE);
			result.put(ResponseConstants.SUCCESS, ResponseConstants.FALSE);
			result.put(ResponseConstants.ERROR_CODE, ErrorCodes.UE);
			result.put(ResponseConstants.MESSAGE, e.getMessage());
		}
		return result;
	}
	
	public static Map<String, Object> cancelSubscription(String json) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		SubscriptionOrderBean bean = jsonToSubscriptionOrderBean(json);
		
		try{
			cancelAccount(bean);
			result.put(ResponseConstants.SUCCESS, ResponseConstants.TRUE);
		}catch (CustomParentException e){
			result.put(ResponseConstants.SUCCESS, ResponseConstants.FALSE);
			result.put(ResponseConstants.ERROR_CODE, e.getErrorCode());
			result.put(ResponseConstants.MESSAGE, e.getMessage());
		}catch (Exception e) {
			result.put(ResponseConstants.SUCCESS, ResponseConstants.FALSE);
			result.put(ResponseConstants.ERROR_CODE, ErrorCodes.UE);
			result.put(ResponseConstants.MESSAGE, e.getMessage());
		}
		return result;
	}
	
	public static Map<String, Object> changeSubscription(String json) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		SubscriptionOrderBean bean = jsonToSubscriptionOrderBean(json);
		
		try{
			changeAccount(bean);
			result.put(ResponseConstants.SUCCESS, ResponseConstants.TRUE);
		}catch (CustomParentException e){
			result.put(ResponseConstants.SUCCESS, ResponseConstants.FALSE);
			result.put(ResponseConstants.ERROR_CODE, e.getErrorCode());
			result.put(ResponseConstants.MESSAGE, e.getMessage());
		}catch (Exception e) {
			result.put(ResponseConstants.SUCCESS, ResponseConstants.FALSE);
			result.put(ResponseConstants.ERROR_CODE, ErrorCodes.UE);
			result.put(ResponseConstants.MESSAGE, e.getMessage());
		}
		return result;
	}
	
	public static Map<String, Object> assignUser(String json) {
		
		Map<String, Object> result = new HashMap<String, Object>();
	
		SubscriptionOrderBean bean = jsonToSubscriptionOrderBean(json);
		
		try{
			assignUserToAccount(bean);
			result.put(ResponseConstants.SUCCESS, ResponseConstants.TRUE);
		}catch (CustomParentException e){
			result.put(ResponseConstants.SUCCESS, ResponseConstants.FALSE);
			result.put(ResponseConstants.ERROR_CODE, e.getErrorCode());
			result.put(ResponseConstants.MESSAGE, e.getMessage());
		}catch (Exception e) {
			result.put(ResponseConstants.SUCCESS, ResponseConstants.FALSE);
			result.put(ResponseConstants.ERROR_CODE, ErrorCodes.UE);
			result.put(ResponseConstants.MESSAGE, e.getMessage());
		}
		return result;
	}
	
	public static Map<String, Object> unAssignUser(String json) {
		
		Map<String, Object> result = new HashMap<String, Object>();
	
		SubscriptionOrderBean bean = jsonToSubscriptionOrderBean(json);
		
		try{
			unAssignUserToAccount(bean);
			result.put(ResponseConstants.SUCCESS, ResponseConstants.TRUE);
		}catch (CustomParentException e){
			result.put(ResponseConstants.SUCCESS, ResponseConstants.FALSE);
			result.put(ResponseConstants.ERROR_CODE, e.getErrorCode());
			result.put(ResponseConstants.MESSAGE, e.getMessage());
		}catch (Exception e) {
			result.put(ResponseConstants.SUCCESS, ResponseConstants.FALSE);
			result.put(ResponseConstants.ERROR_CODE, ErrorCodes.UE);
			result.put(ResponseConstants.MESSAGE, e.getMessage());
		}
		return result;
	}

	public static String createAccount(SubscriptionOrderBean bean) throws CustomParentException {
		String creatorUuid = bean.getCreator().getUuid();
		String companyUuid = bean.getPayload().getCompany().getUuid();
		User user = DbController.findByUuidInUser(creatorUuid);
		Company company = DbController.findByUuidInCompany(companyUuid);
		
		if((user==null) && (company==null)){
			System.out.println("createAccount - no existing account. About to create new account");
			return pushBeanToDb(bean);
		}else{
			throw new UserAlreadyExistsException("An account has already been created by this user or company.");
		}
	}
	
	public static void cancelAccount(SubscriptionOrderBean bean) throws CustomParentException{
		String accountIdentifier = bean.getPayload().getAccount().getAccountIdentifier(); 
		AdminAccount account = DbController.getAdminAccountByAccountIdentifier(accountIdentifier);
		
		if(account==null){
			//account does not exists
			throw new AccountNotFoundException("The account for which yor are trying to cancel the subscription does not exists.");
		}
		
		String eventCreatorUuid = bean.getCreator().getUuid();
		String adminUuid = DbController.getAdminUuidByAccountIdentifier(accountIdentifier);
		AdminAccount adminAccount = DbController.getAdminAccountByAccountIdentifier(accountIdentifier);
		
		if(eventCreatorUuid.equals(adminUuid)){
			if(adminAccount.getStatus() == AccountStatus.CANCELLED){
				//account is already cancelled
				throw new AccountNotFoundException("Subscription is already cancelled for this account.");
			}else{
				adminAccount.setStatus(AccountStatus.CANCELLED);
				DbController.updateInAdminAccount(adminAccount);
				System.out.println("cancelSubscription - subscription cancelled successfully");
			}
		}else{
			throw new ForbiddenException("You are not allowed to cancel the subscription for this account.");
		}
	}
	
	public static void changeAccount(SubscriptionOrderBean bean) throws CustomParentException{
		String accountIdentifier = bean.getPayload().getAccount().getAccountIdentifier();
		String status = bean.getPayload().getAccount().getStatus();
		
		if(!status.equals(AccountStatus.ACTIVE)){
			throw new AccountNotFoundException("The account for which yor are trying to change the subscription does not exists.");
		}
		
		AdminAccount account = DbController.getAdminAccountByAccountIdentifier(accountIdentifier);
		
		if(account==null){
			//account does not exists
			throw new AccountNotFoundException("The account for which yor are trying to change the subscription does not exists.");
		}
		
		String eventCreatorUuid = bean.getCreator().getUuid();
		String adminUuid = DbController.getAdminUuidByAccountIdentifier(accountIdentifier);
		AdminAccount adminAccount = DbController.getAdminAccountByAccountIdentifier(accountIdentifier);
		
		if(eventCreatorUuid.equals(adminUuid)){
			if(adminAccount.getStatus() != AccountStatus.ACTIVE){
				//account is already cancelled
				throw new AccountNotFoundException("this account is not in ACTIVE mode.");
			}else{
				Order order = DbController.findByCreatorUuidInOrder(eventCreatorUuid);
				com.techchallenge.beans.Order orderBean = bean.getPayload().getOrder();
				if(orderBean != null){
					order.setEditionCode(orderBean.getEditionCode());
					order.setPricingDuration(orderBean.getPricingDuration());
					order.setAddonOfferingCode(orderBean.getAddonOfferingCode());
					
					List<com.techchallenge.beans.Items> items = bean.getPayload().getOrder().getItems();
					if(items.size() > 0){
						order.setItemsQuantity(items.get(0).getQuantity());
						order.setItemsUnit(items.get(0).getUnit());
					}
				}
				
				DbController.updateOrder(order);
				System.out.println("changeSubscription - subscription changed successfully");
			}
		}else{
			throw new ForbiddenException("You are not allowed to change the subscription for this account.");
		}
	}
	
	public static void assignUserToAccount(SubscriptionOrderBean bean) throws CustomParentException{
		String accountIdentifier = bean.getPayload().getAccount().getAccountIdentifier(); 
		String creatorUuid = bean.getCreator().getUuid();
		AdminAccount adminAccount = DbController.getAdminAccountByAccountIdentifier(accountIdentifier);
		
		if(adminAccount ==null){
			throw new AccountNotFoundException("The account to which you are trying to assign the user does not exists.");
		}
		
		User creator = DbController.findByUuidInUser(creatorUuid);
		if(creator==null){
			throw new UserNotFoundException("The creator user does not exists.");
		}
		
		String adminUuid = DbController.getAdminUuidByAccountIdentifier(accountIdentifier);
		
		if(creatorUuid.equals(adminUuid)){
			String payloadUuid = bean.getPayload().getUser().getUuid();
			boolean isAlreadyAdded = DbController.isUserAlreadyAddedInTheAccount(payloadUuid,accountIdentifier);
			if(!isAlreadyAdded){
				addNewUserToTheAccount(bean);
			}
		}else{
			throw new ForbiddenException("You are not allowed to add a user to this account.");
		}
	}
	
	public static void unAssignUserToAccount(SubscriptionOrderBean bean) throws CustomParentException{
		String accountIdentifier = bean.getPayload().getAccount().getAccountIdentifier(); 
		String creatorUuid = bean.getCreator().getUuid();
		AdminAccount adminAccount = DbController.getAdminAccountByAccountIdentifier(accountIdentifier);
		
		if(adminAccount ==null){
			throw new AccountNotFoundException("The account to which you are trying to Un-assign the user does not exists.");
		}
		
		User creator = DbController.findByUuidInUser(creatorUuid);
		if(creator==null){
			throw new UserNotFoundException("The creator user does not exists.");
		}
		
		String adminUuid = DbController.getAdminUuidByAccountIdentifier(accountIdentifier);
		
		if(creatorUuid.equals(adminUuid)){
			String payloadUuid = bean.getPayload().getUser().getUuid();
			boolean isPresent = DbController.isUserAlreadyAddedInTheAccount(payloadUuid,accountIdentifier);
			if(isPresent){
				Account account = DbController.findAccountByUserUuid(payloadUuid);
				account.setUserStatus("DELETED");
				DbController.updateAccountInAccount(account);
			}else{
				throw new UserNotFoundException("The user which needs to be unassigned does not exists.");
			}
		}else{
			throw new ForbiddenException("You are not allowed to remove a user to this account.");
		}
	}
}
