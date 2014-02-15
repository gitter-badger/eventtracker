package org.codetest.persistence;

public class DataSource
{
	private String dataSource;
	private String hostName;
	private int portNumber;
	private String dbName;
	private String userName;
	private String password;

	private static final String DEFAULT_DATA_SOURCE = "mysql";
	private static final String DEFAULT_HOST = "localhost";
	private static final int DEFAULT_PORT = 3306;

	private DataSource(String dataSource, String hostName, int portNumber, String dbName, String userName, String password)
	{
		this.dataSource = dataSource;
		this.hostName = hostName;
		this.portNumber = portNumber;
		this.dbName = dbName;
		this.userName = userName;
		this.password = password;
	}

	public static DataSource getInstance(String dbName, String userName)
	{
		return new DataSource(DEFAULT_DATA_SOURCE, DEFAULT_HOST, DEFAULT_PORT, dbName, userName, "");
	}

	public static DataSource getInstance(String hostName, String dbName, String userName)
	{
		return new DataSource(DEFAULT_DATA_SOURCE, hostName, DEFAULT_PORT, dbName, userName, "");
	}

	public String getDataSource()
	{
		return dataSource;
	}

	public void setDataSource(String dataSource)
	{
		this.dataSource = dataSource;
	}

	public String getHostName()
	{
		return hostName;
	}

	public void setHostName(String hostName)
	{
		this.hostName = hostName;
	}

	public int getPortNumber()
	{
		return portNumber;
	}

	public void setPortNumber(int portNumber)
	{
		this.portNumber = portNumber;
	}

	public String getDbName()
	{
		return dbName;
	}

	public void setDbName(String dbName)
	{
		this.dbName = dbName;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getConnectionURL()
	{
		return "jdbc:" + this.dataSource + "://" + this.hostName + ":" + this.portNumber + "/" + this.dbName;
	}

	@Override
	public String toString()
	{
		return "DataSource [dataSource=" + dataSource + ", hostName=" + hostName + ", portNumber=" + portNumber + ", dbName=" + dbName + ", userName=" + userName + ", password=" + password + "]";
	}
}
