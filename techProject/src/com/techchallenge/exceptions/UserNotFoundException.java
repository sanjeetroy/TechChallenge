package com.techchallenge.exceptions;

import com.techchallenge.common.ErrorCodes;

public class UserNotFoundException extends CustomParentException{
	
	private static String message = "";
	
	public UserNotFoundException(String str){
		message = str;
	}
	
	
	public String getErrorCode(){
		return ErrorCodes.UAE;
	}
	
	public String getMessage(){
		return message;
	}

}
