/*package com.facility.management.dal;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

	public static Connection getConnection() {
		 
		//System.out.println("DBHelper: -------- MySQL " + "JDBC Connection  ------------");
 
		try {
 
			Class.forName("com.mysql.jdbc.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("DBHelper: Check Where  your MySQL JDBC Driver exist and " + "Include in your library path!");
			e.printStackTrace();
			return null;
 
		}
 
		//System.out.println("DBHelper: MySQL JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/FACILITY_MANAGEMENT?autoReconnect=true&useSSL=false", "root", "");
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery("SELECT VERSION()");

	            if (rs.next()) {
	                //System.out.println("DBHelper: The Database Version is " + rs.getString(1));
	            }
 
		} catch (SQLException e) {
 
			System.out.println("DBHelper: Connection Failed! Check output console");
			e.printStackTrace();
			return null;
 
		}
 
		if (connection != null) {
			//System.out.println("DBHelper: You have a database connection!");
		} else {
			System.out.println("DBHelper: Failed to make connection!");
		}
		
		return connection;
	}
}
*/