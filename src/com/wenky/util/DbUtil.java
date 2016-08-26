/**
 * 
 */
package com.wenky.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author prasad
 *
 */
public class DbUtil {

	private static Connection con = null;
	
	/**
	 * 
	 */
	public DbUtil() {
		
	}
	
	public static Connection getConnection(){
		if(con != null)
			return con;
		
		try{
			InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			
			Class.forName(properties.getProperty("driver"));
			con = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
