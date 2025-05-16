package DataBaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseClass {
	
Connection con;
	
	public void getConnection (String url , String username , String password ) throws SQLException {
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(url, username, password);
	}catch (Exception e ) {
		
	    }
	}
	
	public void getConnection () throws SQLException {
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3333/projects", "root@%", "root");
	}catch (Exception e ) {
		
	    }
	}
	
	
	public void closeDbConnection() throws SQLException{
		try {
		con.close();
	} catch(Exception e) {
		
	     }
	}
	
	public ResultSet executeselectQuery( String query) throws SQLException {
		ResultSet result = null;
		try {
		Statement stat = con.createStatement();
		 result = stat.executeQuery(query);		
	}catch (Exception e) {
		
	    }
		return result;
	}
	
	public int executeNonselectQuery( String query) throws SQLException {
		int result = 0;
		try {
		Statement stat = con.createStatement();
		 result = stat.executeUpdate(query);		
	}catch (Exception e) {
		
	    }
		return result;
	}
		


}
