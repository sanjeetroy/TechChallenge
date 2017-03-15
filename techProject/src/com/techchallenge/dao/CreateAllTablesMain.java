package com.techchallenge.dao;

public class CreateAllTablesMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CreateTable ct = new CreateTable();
		try{
			ct.createUserTable();
			ct.createAccountTable();
			ct.createAdminAccountTable();	
			ct.createCompanyTable();
			ct.createMarketplaceTable();
			ct.createOrderTable();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
