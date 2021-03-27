package com.example.First;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	static Connection connection = null;
	public static Connection getConnectionValues() throws ClassNotFoundException, SQLException{
		 if(connection == null)
		 {
	 Class.forName("com.mysql.jdbc.Driver");
	 System.out.println("Driver Loaded");
	  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapi","root","root");
	  System.out.println("Connection Done..!!");
	 
		 }
		return connection;

		
	}

}
