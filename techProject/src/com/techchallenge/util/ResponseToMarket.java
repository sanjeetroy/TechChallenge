package com.techchallenge.util;

public class ResponseToMarket {
	boolean success;
	long acctIdentifier;
	
	public ResponseToMarket(){
		success = false;
		acctIdentifier = 1234L;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getAcctIdentifier() {
		return acctIdentifier;
	}

	public void setAcctIdentifier(long acctIdentifier) {
		this.acctIdentifier = acctIdentifier;
	}
}
