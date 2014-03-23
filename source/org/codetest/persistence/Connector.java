package org.codetest.persistence;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class Connector
{
	private static Logger LOGGER = Logger.getLogger(Connector.class.getName());
	
	public static Connection getConnection() 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e)
		{
			LOGGER.log(Level.SEVERE, "MySQL driver not found in classpath");
		}
		Connection conn = null;
		DataSource dataSource = DataSource.getInstance("test", "root");
		
		try
		{
			conn = (Connection) DriverManager.getConnection(dataSource.getConnectionURL());
		}
		catch (SQLException e)
		{
			LOGGER.log(Level.SEVERE, "Failed to Aquire MySQL Connection");
		}
		return conn;
	}
}
