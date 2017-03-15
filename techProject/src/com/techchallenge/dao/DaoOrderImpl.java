package com.techchallenge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.techchallenge.domain.AdminAccount;
import com.techchallenge.domain.Order;
import com.techchallenge.domain.User;

public class DaoOrderImpl implements DaoOrder {
	public void save(Order order){
		StringBuilder sql = new StringBuilder();
		sql.append("insert into orders(editionCode,pricingDuration,addonOfferingCode,itemsQuantity,");
		sql.append("itemsUnit,creatorUuid) ");
		sql.append("values (?,?,?,?,?,?)");
		
		String query = sql.toString(); 
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, order.getEditionCode());
			ps.setString(2, order.getPricingDuration());
			ps.setString(3, order.getAddonOfferingCode());
			ps.setString(4, order.getItemsQuantity());
			ps.setString(5, order.getItemsUnit());
			ps.setString(6, order.getCreatorUuid());
		
			ps.executeUpdate();
			System.out.println("order by " + order.getCreatorUuid() + " has beed saved successfully.");
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
	
	public void update(Order order){
		String query = "update orders set editionCode=?,pricingDuration=?,addonOfferingCode=?,itemsQuantity=?,itemsUnit=? where creatorUuid=?";
		Connection con = null;
		PreparedStatement ps = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, order.getEditionCode());
			ps.setString(2, order.getPricingDuration());
			ps.setString(2, order.getAddonOfferingCode());
			ps.setString(2, order.getItemsQuantity());
			ps.setString(2, order.getItemsUnit());
			ps.setString(2, order.getCreatorUuid());
			
			ps.executeUpdate();
			System.out.println("order has been successfully updated for "+ order.getCreatorUuid());
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
	
	public Order findByUuid(String uuid){
		String query = "select * from orders where creatorUuid = ?";
		Order order = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			con = DbConnection.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, uuid);
			rs = ps.executeQuery();
			
			if(rs.next()){
				order = new Order();
				order.setEditionCode(rs.getString(1));
				order.setPricingDuration(rs.getString(2));
				order.setAddonOfferingCode(rs.getString(3));
				order.setItemsQuantity(rs.getString(4));
				order.setItemsUnit(rs.getString(5));
				order.setCreatorUuid(uuid);
				
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
		return order;
	}
}
