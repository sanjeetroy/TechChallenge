package com.techchallenge.exceptions;

import com.techchallenge.common.ErrorCodes;

public class AccountNotFoundException extends CustomParentException{
	private static String message="";
	public AccountNotFoundException(String str){
		message = str;
	 }
	
	public String getErrorCode(){
		return ErrorCodes.ANF;
	}
	
	public String getMessage(){
		return message;
	}
}
