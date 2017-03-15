package com.techchallenge.exceptions;

import com.techchallenge.common.ErrorCodes;

public class ForbiddenException extends CustomParentException{
	
	private static String message = "";
	
	public ForbiddenException(String str){
		message = str;
	}
	
	public String getErrorCode(){
		return ErrorCodes.FOR;
	}
	
	public String getMessage(){
		return message;
	}
}
