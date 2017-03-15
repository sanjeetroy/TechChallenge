package com.techchallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.techchallenge.domain.Account;
import com.techchallenge.domain.AdminAccount;
import com.techchallenge.domain.User;

public class DaoAccountImpl implements DaoAccount{
	public void save(Account account){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into account(accountIdentifier,parentAccountIdentifier,");
		sql.append("userStatus,userUuid)");
		sql.append("values (?,?,?,?)");
		
		String query = sql.toString(); 
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, account.getAccountIdentifier());
			ps.setString(2, account.getParentAccountIdentifier());
			ps.setString(3, account.getUserStatus());
			ps.setString(4, account.getUserUuid());
		
			ps.executeUpdate();
			System.out.println("Account " + account.getAccountIdentifier() + " has been successfully created.");
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void update(Account account){
		String query = "update account set userStatus=? where accountIdentifier=?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, account.getUserStatus());
			ps.setString(2, account.getAccountIdentifier());
			
			ps.executeUpdate();
			System.out.println("User has been seccussfully Un-Assigned from account.");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public Account findByUuid(String uuid){
		String query = "select * from account where userUuid = ?";
		Account account = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, uuid);
			rs = ps.executeQuery();
			
			if(rs.next()){
				account = new Account();
				account.setAccountIdentifier(rs.getString(1));
				account.setParentAccountIdentifier(rs.getString(2));
				account.setUserStatus(rs.getString(3));
				account.setUserUuid(uuid);
				
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
	
	
	public ArrayList<Account> findByAccountIdentifier(String accountIdentifier){
		String query = "select * from account where accountIdentifier = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Account> accountList = new ArrayList<>();
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, accountIdentifier);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Account account = new Account();
				account.setAccountIdentifier(accountIdentifier);
				account.setParentAccountIdentifier(rs.getString(2));
				account.setUserStatus(rs.getString(3));
				account.setUserUuid(rs.getString(4));
				accountList.add(account);
				
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
		return accountList;
	}
	
	public boolean isUserAlreadyAddedInTheAccount(String uuid){
		boolean result = false;
		Account account = findByUuid(uuid);
		if(account!=null){
			result = true;
		}
		return result;
	}
	
	public ArrayList<String> getAllUsersByAccountIdentifier(String accountIdentifier){
		ArrayList<Account> allAccounts = findByAccountIdentifier(accountIdentifier);
		ArrayList<String> allUsersId = new ArrayList<>();
		for(Account account:allAccounts){
			allUsersId.add(account.getUserUuid());
		}
		
		return allUsersId;
	}
}
