package com.ninza.hrm.api.genericUtility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	public void getDBConnection(String url, String username, String password) throws SQLException {
		try{
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url,username,password);
	}
		catch(Exception e) {
			
		}
	}
	
	public void getDBConnection() throws SQLException {
		try{
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm\",\"root@%\",\"root");
	}
		catch(Exception e) {
			
		}
	}
	
	public void closeDBConnection() throws SQLException {
		try{
			conn.close();
		}catch (Exception e) {
		}
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		ResultSet result =null;
		try {
			Statement stm = conn.createStatement();
			result =  stm.executeQuery(query);
			
		}
		catch (Exception e) {
		}
		return result;
		
	}
	public int executeNonSelectQuery(String query) throws SQLException
	{
		int result =0;
		try {
			Statement stm = conn.createStatement();
			result =  stm.executeUpdate(query);
			
		}
		catch (Exception e) {
		}
		return result;
		
	}
}
