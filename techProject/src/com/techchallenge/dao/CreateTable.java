package com.techchallenge.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	
		public void createUserTable() throws SQLException {
			Connection con = DbConnection.getConnection();
			Statement st=con.createStatement(); 
			
			try{ 
				StringBuilder sql = new StringBuilder();
				sql.append("create table user(uuid varchar(766) primary key,");
				sql.append("email varchar(766),");
				sql.append("firstName varchar(300),");
				sql.append("lastName varchar(300),");
				sql.append("language varchar(300),");
				sql.append("locale varchar(100),");
				sql.append("openId varchar(766),");
				sql.append("city varchar(766),");
				sql.append("country varchar(766),");
				sql.append("state varchar(766),");
				sql.append("street1 varchar(766),");
				sql.append("street2 varchar(766),");
				sql.append("zip varchar(20),");
				sql.append("accountIdentifier varchar(766))");		
	
				String sqlQuery = sql.toString();
				st.execute(sqlQuery); 
				System.out.println("User Table Created"); 
			}catch(Exception e){ 
				e.printStackTrace();
			} 
			st.close(); 
			con.close(); 

		}

		public void createCompanyTable() throws SQLException{
			Connection con = DbConnection.getConnection();
			Statement st=con.createStatement(); 
			try{ 
				StringBuilder sql = new StringBuilder();
				sql.append("create table company(uuid varchar(766) primary key,");
				sql.append("externalId varchar(766),");
				sql.append("name varchar(766),");
				sql.append("email varchar(766),");
				sql.append("phoneNumber varchar(766),");
				sql.append("website varchar(766),");
				sql.append("country varchar(766))");
				
				String sqlQuery = sql.toString(); 
				st.execute(sqlQuery); 
				System.out.println("Company Table Created"); 
			}catch(Exception e){ 
				e.printStackTrace(); 
			} 
			st.close(); 
			con.close(); 
		}
		
		public void createMarketplaceTable() throws SQLException{
			Connection con = DbConnection.getConnection();
			Statement st=con.createStatement(); 
			try{ 
				StringBuilder sql = new StringBuilder();
				sql.append("create table marketplace(marketplaceIdentifier int auto_increment primary key,");
				sql.append("partner varchar(100),");
				sql.append("baseUrl varchar(766))");
				
				String sqlQuery = sql.toString();
				st.execute(sqlQuery); 
				System.out.println("MarketPlace Table Created"); 
			}catch(Exception e){ 
				e.printStackTrace(); 
			} 
			
			st.close(); 
			con.close(); 
		}
		
		public void createOrderTable() throws SQLException{
			Connection con = DbConnection.getConnection();
			 Statement st=con.createStatement(); 
			try{ 
				StringBuilder sql = new StringBuilder();
				
				sql.append("create table orders(orderIdentifier int auto_increment primary key,");
				sql.append("editionCode varchar(766),");
				sql.append("pricingDuration varchar(766),");
				sql.append("addonOfferingCode varchar(766),");
				sql.append("itemsQuantity varchar(500),");
				sql.append("itemsUnit varchar(500),");
				sql.append("creatorUuid varchar(766))");
				
				String sqlQuery = sql.toString();
				st.execute(sqlQuery); 
				System.out.println("Order Table Created"); 
			}catch(Exception e){ 
				e.printStackTrace(); 
			} 
			st.close(); 
			con.close(); 
		}
		
		public void createAccountTable() throws SQLException{
			Connection con = DbConnection.getConnection();
			Statement st=con.createStatement(); 
			try{ 
				StringBuilder sql = new StringBuilder();
				
				sql.append("create table account(accountIdentifier varchar(766) primary key,");
				sql.append("parentAccountIdentifier varchar(766),");
				sql.append("userStatus varchar(100),");
				sql.append("userUuid varchar(766))");
				
				String sqlQuery = sql.toString();
				st.execute(sqlQuery); 
				System.out.println("Account Table Created"); 
			}catch(Exception e){ 
				e.printStackTrace(); 
			} 
			
			st.close(); 
			con.close(); 

		}
		
		public void createAdminAccountTable() throws SQLException{
			Connection con = DbConnection.getConnection();
			Statement st=con.createStatement(); 
			try{ 
				StringBuilder sql = new StringBuilder();
				
				sql.append("create table adminAccount(accountIdentifier varchar(766) primary key,");
				sql.append("adminUserIdentifier varchar(766),");
				sql.append("CompanyUuid varchar(766),");
				sql.append("partner varchar(100),");
				sql.append("baseUrl varchar(766),");
				sql.append("status varchar(100))");
				
				String sqlQuery = sql.toString();
				st.execute(sqlQuery); 
				System.out.println("AdminAccount Table Created"); 
			}catch(Exception e){ 
				e.printStackTrace(); 
			} 
			
			st.close(); 
			con.close(); 

		}

}