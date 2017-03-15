package com.techchallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.techchallenge.domain.Marketplace;

public class DaoMarketplaceImpl implements DaoMarketplace {
	public void save(Marketplace marketplace){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into marketplace(partner,baseUrl)");
		sql.append("values (?,?)");
		
		String query = sql.toString(); 
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, marketplace.getPartner());
			ps.setString(2, marketplace.getBaseUrl());
		
			ps.executeUpdate();
			System.out.println(marketplace.getPartner() + "  has been saved successfully in Markeplace.");
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
}
