package com.techchallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techchallenge.domain.User;

public class DaoUserImpl implements DaoUser{
	
	public void save(User user){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into user(uuid,email,firstName,lastName,language,");
		sql.append("locale,openId,city,country,state,street1,street2,zip,accountIdentifier) ");
		sql.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		String query = sql.toString(); 
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, user.getUuid());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getLanguage());
			ps.setString(6, user.getLocale());
			ps.setString(7, user.getOpenId());
			ps.setString(8, user.getCity());
			ps.setString(9, user.getCountry());
			ps.setString(10, user.getState());
			ps.setString(11, user.getStreet1());
			ps.setString(12, user.getStree2());
			ps.setString(13, user.getZip());
			ps.setString(14, user.getAccountIdentifier());
		
			ps.executeUpdate();
			System.out.println("User has been saved Succussfully");
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
	
	public User findByUuid(String uuid){
		String query = "select * from user where uuid = ?";
		User user = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, uuid);
			rs = ps.executeQuery();
			
			if(rs.next()){
				user = new User();
				user.setUuid(uuid);
				user.setEmail(rs.getString(2));
				user.setFirstName(rs.getString(3));
				user.setLastName(rs.getString(4));
				user.setLanguage(rs.getString(5));
				user.setLocale(rs.getString(6));
				user.setOpenId(rs.getString(7));
				user.setCity(rs.getString(8));
				user.setCountry(rs.getString(9));
				user.setState(rs.getString(10));
				user.setStreet1(rs.getString(11));
				user.setStree2(rs.getString(12));
				user.setZip(rs.getString(13));
				user.setAccountIdentifier(rs.getString(14));
				
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
		return user;
	}
}
