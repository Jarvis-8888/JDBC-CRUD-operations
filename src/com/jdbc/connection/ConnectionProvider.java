package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	private static Connection con;
	
	public static Connection getConnection()
	{
		try {
			
			//Load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Connection
			
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String password="Rc@8888052448";
			
			con = DriverManager.getConnection(url, user, password);			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
