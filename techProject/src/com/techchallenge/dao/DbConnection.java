package com.techchallenge.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	static DbConnection connection;
	//private static String user = "roottech";
	private static String user = "root";
	private static String pass = "password";
	private static String dbClass = "com.mysql.jdbc.Driver";
	//private static String dbDriver = "jdbc:mysql://www.db4free.net:3306/techchallenge";
	private static String dbDriver = "jdbc:mysql://localhost:3306/techchallenge";
	
	private DbConnection(){
		try{
			Class.forName(dbClass);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	public static Connection getConnection(){
		if(connection == null){
			connection = new DbConnection();
		}
		
		try{
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart?autoReconnect=true&useSSL=false","root","password01");
			Connection con = DriverManager.getConnection(dbDriver + "?autoReconnect=true&useSSL=false",user,pass);
			//System.out.println("successful connection");
			return con;
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		return null;
	}

}
