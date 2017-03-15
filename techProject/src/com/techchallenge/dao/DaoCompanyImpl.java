package com.techchallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techchallenge.domain.Company;

public class DaoCompanyImpl implements DaoCompany{
	public void save(Company company){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into company(uuid,externalId,name,email,phoneNumber,");
		sql.append("website,country) ");
		sql.append("values (?,?,?,?,?,?,?)");
		
		String query = sql.toString(); 
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, company.getUuid());
			ps.setString(2, company.getExternalId());
			ps.setString(3, company.getName());
			ps.setString(4, company.getEmail());
			ps.setString(5, company.getPhoneNumber());
			ps.setString(6, company.getWebsite());
			ps.setString(7, company.getCountry());
		
			ps.executeUpdate();
			System.out.println("company " + company.getUuid() + " has been saved Succesfully");
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
	
	public Company findByUuid(String uuid){
		String query = "select * from company where uuid = ?";
		Company company = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, uuid);
			rs = ps.executeQuery();
			
			if(rs.next()){
				company = new Company();
				company.setUuid(uuid);
				company.setExternalId(rs.getString(2));
				company.setName(rs.getString(3));
				company.setEmail(rs.getString(4));
				company.setPhoneNumber(rs.getString(5));
				company.setWebsite(rs.getString(6));
				company.setCountry(rs.getString(7));
				
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
		return company;
	}
}
