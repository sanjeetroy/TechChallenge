package com.techchallenge.exceptions;

import com.techchallenge.common.ErrorCodes;

public class UserAlreadyExistsException extends CustomParentException{
	private static String message = "";
	public UserAlreadyExistsException(String str){
		message = str;
	}
	
	
	public String getErrorCode(){
		return ErrorCodes.UAE;
	}
	
	public String getMessage(){
		return message;
	}

}
