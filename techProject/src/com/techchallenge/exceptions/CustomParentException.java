package com.techchallenge.exceptions;

import com.techchallenge.common.ErrorCodes;

public class CustomParentException extends Exception{
	public CustomParentException(String s){
		super(s);
	}
	
	public CustomParentException(){
		super();
	}
	
	public String getErrorCode(){
		return ErrorCodes.UE;
	}
}
