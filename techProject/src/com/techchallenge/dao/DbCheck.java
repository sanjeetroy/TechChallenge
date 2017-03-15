package com.techchallenge.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techchallenge.domain.Account;

public class DbCheck {

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
		/*
		Account acc = findByAccountIdentifier("1234");
		if(acc==null){
			System.out.println("baby its null try something else");
		}
		*/
	}
	
	public static Account findByAccountIdentifier(String accountIdentifier){
		String query = "select * from account where accountIdentifier = ?";
		Account account = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, accountIdentifier);
			rs = ps.executeQuery();
			
			if(rs.next()){
				account = new Account();
				account.setAccountIdentifier(accountIdentifier);
				account.setParentAccountIdentifier(rs.getString(2));
				account.setUserStatus(rs.getString(3));
				account.setUserUuid(rs.getString(4));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return account;
	}

}
