package com.techchallenge.util;

import java.net.HttpURLConnection;

import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.techchallenge.beans.SubscriptionOrderBean;
import com.techchallenge.common.EventTypes;
import com.techchallenge.controller.DbController;
import com.techchallenge.controller.WebController;

public class RequestToResponse {
	private static Map<String, Object> result;
	public  void requestToResponse(HttpURLConnection url){
		String json = WebController.getJsonFromUrl(url);
		String typeOfEvent = getTypeOfJson(json);
		
		System.out.println("Event type = " + typeOfEvent);
		
		if(typeOfEvent.equals(EventTypes.SUBSCRIPTION_ORDER)){
			result = WebController.createSubscription(json);
		}
		
		else if(typeOfEvent.equals(EventTypes.SUBSCRIPTION_CANCEL)){
			result = WebController.cancelSubscription(json);
		}
		else if(typeOfEvent.equals(EventTypes.SUBSCRIPTION_CHANGE)){
			result = WebController.changeSubscription(json);
		}
		else if(typeOfEvent.equals(EventTypes.USER_ASSIGNMENT)){
			result = WebController.assignUser(json);
		}
		else if(typeOfEvent.equals(EventTypes.USER_UNASSIGNMENT)){
			result = WebController.unAssignUser(json);
		}
	}
	
	public  String getTypeOfJson(String json){
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;
		try{
			jsonNode = objectMapper.readTree(json);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		String type = jsonNode.get("type").getTextValue();
		return type;
	}
	
	public  String getJsonResponse(){
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = "";
		try{
			jsonResult = mapper.writeValueAsString(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Json Result ========= " + jsonResult);
        return jsonResult;
	}
}
