package com.techchallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techchallenge.domain.Account;
import com.techchallenge.domain.AdminAccount;

public class DaoAdminAccountImpl implements DaoAdminAccount{
	public void save(AdminAccount adminAccount){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into adminAccount(accountIdentifier,adminUserIdentifier,");
		sql.append("CompanyUuid,partner,baseUrl,status)");
		sql.append("values (?,?,?,?,?,?)");
		
		String query = sql.toString(); 
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, adminAccount.getAccountIdentifier());
			ps.setString(2, adminAccount.getAdminUserIdentifier());
			ps.setString(3, adminAccount.getCompanyUuid());
			ps.setString(4, adminAccount.getPartner());
			ps.setString(5, adminAccount.getBaseUrl());
			ps.setString(6, adminAccount.getStatus());
		
			ps.executeUpdate();
			System.out.print("Admin " + adminAccount.getAdminUserIdentifier());
			System.out.println(" has been successfully assigned as Admin to \nAccount " + adminAccount.getAccountIdentifier());
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
	
	public String getAdminByAccountIdentifier(String accountIdentifier){
		String query = "select * from adminAccount where accountIdentifier = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String adminUuid = "";
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, accountIdentifier);
			rs = ps.executeQuery();
			
			if(rs.next()){
				adminUuid = rs.getString(2);
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
		return adminUuid;
	}
	
	public AdminAccount getAdminAccountByAccountIdentifier(String accountIdentifier){
		String query = "select * from adminAccount where accountIdentifier = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AdminAccount adminAccount = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, accountIdentifier);
			rs = ps.executeQuery();
			
			if(rs.next()){
				adminAccount = new AdminAccount();
				adminAccount.setAccountIdentifier(rs.getString(1));
				adminAccount.setAdminUserIdentifier(rs.getString(2));
				adminAccount.setCompanyUuid(rs.getString(3));
				adminAccount.setPartner(rs.getString(4));
				adminAccount.setBaseUrl(rs.getString(5));
				adminAccount.setStatus(rs.getString(6));
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
		return adminAccount;
	}
	
	public void update(AdminAccount adminAccount){
		String query = "update adminAccount set status=? where accountIdentifier=?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, adminAccount.getStatus());
			ps.setString(2, adminAccount.getAccountIdentifier());
			
			ps.executeUpdate();
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
}
